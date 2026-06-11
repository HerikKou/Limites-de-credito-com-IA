package Score.Service.Service;

import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.retry.annotation.*;
import org.springframework.stereotype.Component;
import org.slf4j.*;
import Score.Service.DTO.CreditoCriadoEventoDTO;
import Score.Service.DTO.HistoricoCriadoEventoDTO;
import Score.Service.Model.Score;
import Score.Service.Repository.ScoreRepository;

@Component
public class ConsumirMensagem {

 private final IdempotenciaService idempotencia;
private final ScoreRepository repository;
public ConsumirMensagem(IdempotenciaService idempotencia, ScoreRepository repository) {
    this.idempotencia = idempotencia;
    this.repository = repository;
}
private Logger log = LoggerFactory.getLogger(ConsumirMensagem.class);
@Retryable(maxAttempts = 5, backoff = @Backoff(delay = 2000))
@KafkaListener(topics = "credito-evento-score", groupId = "score-service-group-v1")
public void consumirMensagem(CreditoCriadoEventoDTO credito){
log.info("Credito recebido :{}"+credito.getCreditoId().toString());

idempotencia.CreditojaProcessado(credito.getCreditoId());

Score score = new Score();
score.setCreditoId(credito.getCreditoId());
score.setLimiteDeCredito(credito.getLimiteDeCredito());
score.setQuantidadeDeConsultas(credito.getQuantidadeDeConsultas());
score.setQuantidadeDeAtrasos(credito.getQuantidadeDeAtrasos());
repository.save(score);

}
@Retryable(maxAttempts = 5, backoff = @Backoff(delay = 2000))
@KafkaListener(topics = "historico-topic", groupId = "score-service-group-v1")
public void consumirMensagemHistorico(HistoricoCriadoEventoDTO historico){
log.info("Credito recebido :{}"+historico.getHistoricoId().toString());

idempotencia.HistoricoJaProccessado(historico.getHistoricoId());

Score score = new Score();
score.setHistoricoId(historico.getHistoricoId());
score.setValorGasto(historico.getValorGasto());
score.setTempodeHistorico(historico.getData());
repository.save(score);

}


@DltHandler
public void dlqHandler(Long creditoId){
    log.error("Erro ao processar evento",creditoId);
}

@DltHandler
public void dlqHandlerHistorico(Long historicoId){
    log.error("Erro ao processar evento",historicoId);
}
}
