package Historico_Service.Service;

import org.springframework.stereotype.Component;

import Historico_Service.DTO.HistoricoResponseDTO;
import Historico_Service.Model.Historico;

@Component
public class TransformarEmResponse {

public HistoricoResponseDTO transformarResponse(Historico historico){

    HistoricoResponseDTO response = new HistoricoResponseDTO();
    response.setId(historico.getId());
    response.setIdCredito(historico.getIdCredito());
    response.setEstabelecimento(historico.getEstabelecimento());
    response.setDescricao(historico.getDescricao());
    response.setValor(historico.getValorGasto());
    return response ;
}

}
