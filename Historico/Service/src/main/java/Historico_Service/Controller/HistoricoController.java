package Historico_Service.Controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Historico_Service.DTO.HistoricoRequestDTO;
import Historico_Service.DTO.HistoricoResponseDTO;
import Historico_Service.Model.Historico;
import Historico_Service.Service.CalcularGastoTotal;
import Historico_Service.Service.ConsultarHistorico;
import Historico_Service.Service.CriarHistorico;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/historico")
public class HistoricoController {

    private final ConsultarHistorico consultarHistorico;
    private final CriarHistorico historicoservice;
    private final CalcularGastoTotal calcularGastoTotal;

    public HistoricoController(ConsultarHistorico consultarHistorico, CriarHistorico historicoservice, CalcularGastoTotal calcularGastoTotal) {
        this.consultarHistorico = consultarHistorico;
        this.historicoservice = historicoservice;
        this.calcularGastoTotal = calcularGastoTotal;
    }

@GetMapping("/consultar/{idCredito}")
public ResponseEntity<List<Historico>> consultarHistorico(@PathVariable Long idCredito) {

    List<Historico> historicos = consultarHistorico.consultarHistoricoPorIdCredito(idCredito);
    if (historicos.isEmpty()) {
        return ResponseEntity.status(404).build();
    }
    return ResponseEntity.status(200).body(historicos);
}

@PostMapping("/criar/{idCredito}")
public ResponseEntity<HistoricoResponseDTO> criarHistorico(@RequestBody HistoricoRequestDTO request, @PathVariable Long idCredito) {
    HistoricoResponseDTO historico = historicoservice.criar(request, idCredito);
    return ResponseEntity.status(201).body(historico);

}

@GetMapping("/gasto-total/{idCredito}")
public ResponseEntity<?> calcularGastoTotal(@PathVariable Long idCredito) {
    List<Historico> historicos = consultarHistorico.consultarHistoricoPorIdCredito(idCredito);
    if (historicos.isEmpty()) {
        return ResponseEntity.status(404).build();
    }
    calcularGastoTotal.calcularGastoTotal(historicos);
    return ResponseEntity.ok("Evento enviado para processamento");
    
    


}








}
