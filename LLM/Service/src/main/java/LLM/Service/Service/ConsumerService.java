package LLM.Service.Service;

import org.slf4j.*;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.retry.annotation.*;

import org.springframework.stereotype.Component;

import LLM.Service.DTO.LlmEventoDTO;
import LLM.Service.DTO.ScoreAtualizadoEventoDTO;
import LLM.Service.Model.Llm;
import LLM.Service.Repository.LlmRepository;

@Component
public class ConsumerService {

    
private final Logger log = LoggerFactory.getLogger(ProducerService.class);
private final LlmRepository repository;
private final Idempotencia idempotencia;
private final PromptService prompt;
private final ProducerService producer;
public ConsumerService(LlmRepository repository, Idempotencia idempotencia, PromptService prompt , ProducerService  producer){
    this.repository = repository;
    this.idempotencia = idempotencia;
    this.prompt = prompt ;
    this.producer = producer;
}
@Retryable(maxAttempts = 5, backoff = @Backoff(delay = 3000))
@KafkaListener(topics = "score-service", groupId = "llm-service-group-v1")
public void ConsumirMensagem(ScoreAtualizadoEventoDTO score){
    idempotencia.ScoreJaProcessado(score.getIdScore());
    
    String cenario = prompt.gerarPrompt(score);
    log.info("Score recebido:{}",score.getIdScore());
   
    Llm llm = new Llm();
    llm.setIdScore(score.getIdScore());
    llm.setCreditoId(score.getCreditoId());
    llm.setCenario(cenario);
    repository.save(llm);
    producer.enviarEvento(new LlmEventoDTO(llm.getId(), llm.getCreditoId(), llm.getCenario()));


}
@DltHandler
public void DlqHandler(ScoreAtualizadoEventoDTO score){
    log.error("Evento armazenado no dlq", score.getIdScore());
}
}
