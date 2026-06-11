package Credito_Service.Service;

import Credito_Service.DTO.CreditoRequestDTO;

import Credito_Service.Model.Credito;

public class TransformarEmModel {


    public Credito transformarEmModel(CreditoRequestDTO request) {
        Credito credito = new Credito();
        credito.setSalario(request.getSalario());   
        credito.setLimiteDeCredito(request.getLimiteDeCredito());
        credito.setLimiteDisponivel(request.getLimiteDisponivel());
        credito.setQuantidadeDeAtrasos(request.getQuantidadeDeAtrasos());
        credito.setQuantidadeDeConsultas(request.getQuantidadeDeConsultas());     
    
        return credito;
    }
}
