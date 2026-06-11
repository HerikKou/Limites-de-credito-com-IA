package LLM.Service.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopic {

@Bean
public NewTopic topicLLM(){
     return TopicBuilder.name("llm-service")
                .partitions(1)
                .replicas(1)
                 .build();

}


}
