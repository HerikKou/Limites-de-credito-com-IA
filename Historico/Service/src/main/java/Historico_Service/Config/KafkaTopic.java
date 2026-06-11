package Historico_Service.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopic {


    @Bean
    public NewTopic historicoTopic(){
        return  TopicBuilder.name("historico-topic").partitions(1).replicas(1).build();
    }
}
