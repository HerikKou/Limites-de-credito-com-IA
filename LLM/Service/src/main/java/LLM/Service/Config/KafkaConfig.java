package LLM.Service.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import LLM.Service.DTO.LlmEventoDTO;

@Configuration
public class KafkaConfig {



@Bean
public KafkaTemplate<String, LlmEventoDTO> kafkaTemplateLLM(ProducerFactory<String, LlmEventoDTO> producerFactory){
    return new KafkaTemplate<>(producerFactory);
}




}
