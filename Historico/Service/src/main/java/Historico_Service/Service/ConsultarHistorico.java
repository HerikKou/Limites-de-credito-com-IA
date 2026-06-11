package Historico_Service.Service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import Historico_Service.Model.Historico;
import Historico_Service.Repository.HistoricoRepository;

@Component
public class ConsultarHistorico {

    private final HistoricoRepository historicoRepository;

    public ConsultarHistorico(HistoricoRepository historicoRepository) {
        this.historicoRepository = historicoRepository;
    }

    @Cacheable(value = "historicoCache", key = "#idCredito")
    public List<Historico> consultarHistoricoPorIdCredito(Long idCredito) {
        
        return historicoRepository.findAllByCreditoId(idCredito);

    }
}
