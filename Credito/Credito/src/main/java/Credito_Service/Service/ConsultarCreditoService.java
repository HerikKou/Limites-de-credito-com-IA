package Credito_Service.Service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import Credito_Service.DTO.CreditoResponseDTO;
import Credito_Service.Exception.CreditoException;
import Credito_Service.Model.Credito;
import Credito_Service.Repository.CreditoRepository;

@Component
public class ConsultarCreditoService {

    private final CreditoRepository creditoRepository;
    private final CreditoException creditoException;
    public ConsultarCreditoService(CreditoRepository creditoRepository, CreditoException creditoException) {
        this.creditoRepository = creditoRepository;
        this.creditoException = creditoException;
    }
    
    @Cacheable(value = "creditoCache", key = "#id")
    public CreditoResponseDTO consultarCredito(Long id) {
        Credito credito = creditoRepository.findById(id).orElseThrow(() -> new CreditoException("Crédito não encontrado"));
        return new CreditoResponseDTO(credito.getId(), credito.getSalario(), credito.getLimiteDeCredito(), credito.getLimiteDisponivel(), credito.getQuantidadeDeAtrasos(), credito.getQuantidadeDeConsultas());
    }
}
