package Historico_Service.Service;

import org.slf4j.*;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import Historico_Service.DTO.HistoricoEventoDTO;

@Component
public class ProducerService {

private final Logger log = LoggerFactory.getLogger(ProducerService.class);

private final KafkaTemplate<String, HistoricoEventoDTO> kafkaTemplateHistorico;

public ProducerService(KafkaTemplate<String, HistoricoEventoDTO> kafkaTemplateHistorico) {
    this.kafkaTemplateHistorico = kafkaTemplateHistorico;

}

public void enviarEvento(HistoricoEventoDTO evento) {
   try {
        kafkaTemplateHistorico.send("historico-topic", evento);
        log.info("Evento enviado para o Kafka: {}", evento);
    } catch (Exception e) {
        log.error("Erro ao enviar evento para o Kafka", e.getMessage());
    }

}


}