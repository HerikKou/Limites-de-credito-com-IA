package Score.Service.Service;

import org.slf4j.*;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import Score.Service.DTO.ScoreEventoDTO;

@Component
public class Producer {

    private final KafkaTemplate<String,ScoreEventoDTO> kafkatemplatescore;
    private Logger log = LoggerFactory.getLogger(Producer.class);

    public Producer(KafkaTemplate<String,ScoreEventoDTO> kafkatemplatescore){
        this.kafkatemplatescore = kafkatemplatescore;
    }

    public void enviarScore(ScoreEventoDTO evento){
        try {
            kafkatemplatescore.send("score-topic" , evento);
            log.info("Evento enviado para o kafka");
            
        } catch (Exception e) {
            log.error("Erro ao enviar evento"+ e.getMessage());
        }
    }
}
