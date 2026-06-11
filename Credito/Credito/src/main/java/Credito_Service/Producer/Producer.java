package Credito_Service.Producer;






import org.slf4j.*;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import Credito_Service.DTO.CreditoEventoHistoricoDTO;
import Credito_Service.DTO.CreditoEventoScoreDTO;

@Component
public class Producer {
   Logger logger = LoggerFactory.getLogger(Producer.class);

    private final KafkaTemplate<String, Object> kafkaTemplateScore;
    private final KafkaTemplate<String, Object> kafkaTemplateHistorico;

    public Producer(KafkaTemplate<String, Object> kafkaTemplateScore,
                    KafkaTemplate<String, Object> kafkaTemplateHistorico) {
        this.kafkaTemplateScore = kafkaTemplateScore;
        this.kafkaTemplateHistorico = kafkaTemplateHistorico;
    }
    public void sendCreditoEventoScore(CreditoEventoScoreDTO creditoEventoScoreDTO) {
        try {
            kafkaTemplateScore.send("credito-evento-score", creditoEventoScoreDTO.getId().toString(), creditoEventoScoreDTO);
        } catch (Exception e) {
            logger.error("Erro ao enviar mensagem para o tópico credito-evento-score: " + e.getMessage());
        }
    }

    public void sendCreditoEventoHistorico(CreditoEventoHistoricoDTO creditoEventoHistoricoDTO) {
        try {
            kafkaTemplateHistorico.send("credito-evento-historico", creditoEventoHistoricoDTO.getId().toString(), creditoEventoHistoricoDTO);
        } catch (Exception e) {
            logger.error("Erro ao enviar mensagem para o tópico credito-evento-historico: " + e.getMessage());
        }
    }
}
