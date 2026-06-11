package Credito_Service.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopic {

@Bean
public NewTopic creditoEventoScoreTopic() {
    return TopicBuilder.name("credito-evento-score")
            .partitions(1)
            .replicas(1)
            .build();

}

@Bean
public NewTopic creditoEventoHistoricoTopic() {
    return TopicBuilder.name("credito-evento-historico")
            .partitions(1)
            .replicas(1)
            .build();
}

}