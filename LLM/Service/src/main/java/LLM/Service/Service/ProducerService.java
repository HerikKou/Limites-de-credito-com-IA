package LLM.Service.Service;



import org.slf4j.*;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import LLM.Service.DTO.LlmEventoDTO;

@Component
public class ProducerService {

private final Logger log = LoggerFactory.getLogger(ProducerService.class);

private final KafkaTemplate<String, LlmEventoDTO> kafkaTemplate;
public ProducerService(KafkaTemplate<String, LlmEventoDTO> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
}
public void enviarEvento(LlmEventoDTO evento) {
   try {
        kafkaTemplate.send("llm-service", evento);
        log.info("evento enviado para o kafka");
    } catch (Exception e) {
        log.info("Erro ao enviar evento");
    }

}

}
