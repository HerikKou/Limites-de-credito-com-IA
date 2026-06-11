package Score.Service.Service;

import org.slf4j.*;
import org.springframework.stereotype.Service;

import Score.Service.DTO.ScoreEventoDTO;
import Score.Service.DTO.ScoreResponse;
import Score.Service.Model.Score;
import Score.Service.Repository.ScoreRepository;

@Service
public class ScoreService {
private Logger log = LoggerFactory.getLogger(ScoreService.class);
    private final ScoreRepository repository;
    private final ScoreFinal scoreFinal;
    private final Producer producer;
    public ScoreService(ScoreRepository repository, ScoreFinal scoreFinal, Producer producer) {
        this.repository = repository;
        this.scoreFinal = scoreFinal;
        this.producer = producer;
    }


    public void enviar(Long creditoId){

    Score score = repository.findByCreditoId(creditoId);

    ScoreResponse response = new ScoreResponse();

    response.setCreditoId(score.getCreditoId());
    response.setHistoricoId(score.getHistoricoId());
    response.setLimiteDeCredito(score.getLimiteDeCredito());
    response.setValorGasto(score.getValorGasto());
    response.setQuantidadeDeAtrasos(score.getQuantidadeDeAtrasos());
    response.setQuantidadeDeConsultas(score.getQuantidadeDeConsultas());
    response.setTempoDeHistorico(score.getTempodeHistorico());

    int scoreFinalCalculado = scoreFinal.calcularScoreFinal(response);

    score.setScorefinal(scoreFinalCalculado);
    score.setStatus(scoreFinal.validarScore(response));

    repository.save(score);

   producer.enviarScore(new ScoreEventoDTO(score.getId(), score.getCreditoId(), score.getStatus()));
}

    } 

