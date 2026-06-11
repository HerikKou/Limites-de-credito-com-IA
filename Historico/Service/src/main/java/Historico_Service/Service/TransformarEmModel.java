package Historico_Service.Service;

import org.springframework.stereotype.Component;

import Historico_Service.DTO.HistoricoRequestDTO;
import Historico_Service.Model.Historico;

@Component
public class TransformarEmModel {



    public Historico transformar(HistoricoRequestDTO request, Historico historico){
        historico.setEstabelecimento(request.getEstabelecimento());
        historico.setDescricao(request.getDescricao());
        historico.setValorGasto(request.getValorGasto());
        return historico;

    }
}
