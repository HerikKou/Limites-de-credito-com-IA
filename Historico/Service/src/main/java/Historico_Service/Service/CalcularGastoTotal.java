package Historico_Service.Service;
import org.springframework.stereotype.Component;
import Historico_Service.Service.ProducerService;
import Historico_Service.DTO.HistoricoEventoDTO;
import Historico_Service.Model.Historico;
import Historico_Service.Repository.HistoricoRepository;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class CalcularGastoTotal {


    private final ProducerService producerService;
    private final HistoricoRepository repository;
    public CalcularGastoTotal(ProducerService producerService, HistoricoRepository repository) {
        this.producerService = producerService;
        this.repository = repository;
    }

    public void calcularGastoTotal(List<Historico> historicos) {
        
       BigDecimal totalgasto = historicos.stream()
                .map(Historico::getValorGasto)
                .reduce(BigDecimal.ZERO, BigDecimal::add);


    HistoricoEventoDTO evento = new HistoricoEventoDTO();

    evento.setIHistoricod(historicos.get(0).getId());
    evento.setCreditoId(historicos.get(0).getIdCredito());
    evento.setValorGasto(totalgasto);
    evento.setData(historicos.get(0).getData());

    enviar(evento);
    }

    public void enviar(HistoricoEventoDTO evento) {
    producerService.enviarEvento(evento);
    }


   

}
