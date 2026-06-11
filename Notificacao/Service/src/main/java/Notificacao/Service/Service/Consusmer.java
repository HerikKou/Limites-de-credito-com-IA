package Notificacao.Service.Service;

import Notificacao.Service.Model.*;
import java.util.logging.Logger;
import Notificacao.Service.Repository.NotificacaoRepository;
import org.slf4j.*;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.resilience.annotation.*;
import org.springframework.stereotype.Component;

import Notificacao.Service.DTO.LlmCriadoEventoDTO;

@Component
public class Consusmer {
    private final Logger log = LoggerFactory.getLogger(Consumer.class);
    private final NotificacaoRepository repository;
    public Consusmer(NotificaacaoRepository repository){
        this.repository = repository;
    }
    @Retryable(maxAttempts = 5, backoff = @Backoff(delay = 2000))
    @KafkaListener(topics = "llm-service", groupId  = "notificacao-service-group-v1")
    public void consumirEvento(LlmCriadoEventoDTO evento ){
        log.info("Cenario recebido:"+evento.getIdLlm());
        Notificacao notificacao = new Notificacao();
        notificacao.setIdLlm(evento.getIdLlm());
        notificacao.setCreditoId(evento.getCreditoId());
        notificacao.setCenario(evento.getCenario());
        repository.save(notificacao);

    }

    @DltHandler
    public void dlqHandler(llmCriadoEventoDTO evento){
        log.error("Erro ao processar evento:"+evento.getidLlm());
    }
}
