package Historico_Service.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.*;

import Historico_Service.DTO.HistoricoEventoDTO;



@Configuration
public class KafkaConfig {

@Bean
public KafkaTemplate<String, HistoricoEventoDTO> kafkaTemplateHistorico(
            ProducerFactory<String, HistoricoEventoDTO> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }


}
