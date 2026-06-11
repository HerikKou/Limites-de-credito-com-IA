package Historico_Service.Service;


import org.slf4j.*;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.retry.annotation.*;
import org.springframework.stereotype.Component;

import Historico_Service.DTO.CreditoCriadoDTO;
import Historico_Service.Model.Historico;
import Historico_Service.Repository.HistoricoRepository;

@Component
public class ConsumirMensagem {

private final Logger log = LoggerFactory.getLogger(ConsumirMensagem.class);
private final HistoricoRepository repository ;
private final IdempotenciaService idempotenciaService;

 public ConsumirMensagem(HistoricoRepository repository, IdempotenciaService idempotenciaService){
    this.repository = repository;
    this.idempotenciaService = idempotenciaService;
    
 }

@Retryable(maxAttempts = 5, backoff = @Backoff(delay = 2000))
@KafkaListener(topics = "credito-evento-histórico", groupId = "historico-service-group-v1")
public void consumir(CreditoCriadoDTO credito){
    log.info("Credito Recebido: {}", credito.getIdCredito());
    
    if (idempotenciaService.CreditoJaProcessado(credito.getIdCredito())) {
        log.info("Crédito com ID {} já processado. Ignorando evento duplicado.", credito.getIdCredito());
        return;
    }
   
    processarMensagemDLQ(credito.getIdCredito());

    Historico historico = new Historico();
    historico.setIdCredito(credito.getIdCredito());
    repository.save(historico);

}
@DltHandler
public void processarMensagemDLQ(Long idCredito) {
    log.error("Mensagem enviada para DLQ: {}", idCredito);
    

}
}
