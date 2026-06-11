package LLM.Service.Service;

import org.springframework.stereotype.Component;

import LLM.Service.DTO.LlmResponseDTO;
import LLM.Service.DTO.ScoreAtualizadoEventoDTO;
import LLM.Service.Repository.LlmRepository;

@Component
public class Idempotencia {

private final LlmRepository repository ;
public Idempotencia(LlmRepository repository){
    this.repository = repository;

}
    public boolean ScoreJaProcessado(Long idScore){
        return repository.existyByScoreId(idScore);
    }
}
