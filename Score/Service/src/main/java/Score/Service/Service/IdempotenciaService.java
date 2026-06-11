package Score.Service.Service;

import org.springframework.stereotype.Component;

import Score.Service.DTO.ScoreResponse;
import Score.Service.Repository.ScoreRepository;

@Component
public class IdempotenciaService {

    private final ScoreRepository repository;
    
    public IdempotenciaService(ScoreRepository repository) {
        this.repository = repository;
    }

    public boolean CreditojaProcessado(Long idCreditoProcessado){

       return repository.existsByCreditoId(idCreditoProcessado);
      
    }

    public boolean HistoricoJaProccessado(Long idHistoricoProcessado){
      return  repository.existsByHistoricoId(idHistoricoProcessado);
      
    }
}
