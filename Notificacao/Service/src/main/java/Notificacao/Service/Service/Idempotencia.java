package Notificacao.Service.Service;
import Notificacao.Service.Repository.NotificacaoRepository;
import org.springframework.stereotype.Component;
@Component
public class Idempotencia {

    private final NotificacaoRepository repository;
    public Idempotencia(NotificaacaoRepository repository){
        this.repository = repository;
    }

    public boolean LlmJaProcessado(Long idllmProcessado){
        return repository.existsByIdLlm(idllmProcessado);
    }
}
