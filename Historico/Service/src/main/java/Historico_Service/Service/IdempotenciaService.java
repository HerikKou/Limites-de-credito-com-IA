package Historico_Service.Service;
import org.slf4j.*;
import org.springframework.stereotype.Component;
import Historico_Service.Repository.HistoricoRepository;

@Component
public class IdempotenciaService {


    private final Logger log = LoggerFactory.getLogger(IdempotenciaService.class);
    private final HistoricoRepository historicoRepository;
    public IdempotenciaService(HistoricoRepository historicoRepository) {
        this.historicoRepository = historicoRepository;
    }

    public boolean CreditoJaProcessado(Long idCredito) {
        boolean existe = historicoRepository.existsByIdCredito(idCredito);
       
        if(existe) {
            return true;
        } 
        return false;
    }
}
