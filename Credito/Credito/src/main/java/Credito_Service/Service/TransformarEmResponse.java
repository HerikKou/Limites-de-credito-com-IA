package Credito_Service.Service;

import Credito_Service.DTO.CreditoResponseDTO;
import Credito_Service.Model.Credito;

public class TransformarEmResponse {

public CreditoResponseDTO  transformarEmResponse(Credito credito) {
        CreditoResponseDTO response = new CreditoResponseDTO();
        response.setId(credito.getId());
        response.setSalario(credito.getSalario());
        response.setLimiteDeCredito(credito.getLimiteDeCredito());
        response.setLimiteDisponivel(credito.getLimiteDisponivel());
        response.setQuantidadeDeAtrasos(credito.getQuantidadeDeAtrasos());
        response.setQuantidadeDeConsultas(credito.getQuantidadeDeConsultas());
        
        return response;
    }


}
