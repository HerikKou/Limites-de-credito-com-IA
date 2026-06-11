package Credito_Service.Service;

import org.springframework.stereotype.Service;

import Credito_Service.DTO.CreditoEventoHistoricoDTO;
import Credito_Service.DTO.CreditoEventoScoreDTO;
import Credito_Service.DTO.CreditoRequestDTO;
import Credito_Service.DTO.CreditoResponseDTO;
import Credito_Service.Model.Credito;
import Credito_Service.Producer.Producer;
import Credito_Service.Repository.CreditoRepository;

@Service
public class CriarCreditoService {
    
    private final CreditoRepository creditoRepository;
    private final Producer producer;
    private final TransformarEmModel transformarEmModel;
    private final TransformarEmResponse transformarEmResponse;

    public CriarCreditoService(CreditoRepository creditoRepository, Producer producer, TransformarEmModel transformarEmModel, TransformarEmResponse transformarEmResponse) {
        this.creditoRepository = creditoRepository;
        this.producer = producer;
        this.transformarEmModel = transformarEmModel;
        this.transformarEmResponse = transformarEmResponse;
    }


    public CreditoResponseDTO criarCredito(CreditoRequestDTO request) {
        Credito credito = transformarEmModel.transformarEmModel(request);
        Credito creditoSalvo = creditoRepository.save(credito);
        CreditoEventoScoreDTO creditoEventoScoreDTO = new CreditoEventoScoreDTO(creditoSalvo.getId(), creditoSalvo.getLimiteDeCredito(), creditoSalvo.getQuantidadeDeAtrasos(), creditoSalvo.getQuantidadeDeConsultas());
        CreditoEventoHistoricoDTO creditoEventoHistoricoDTO = new CreditoEventoHistoricoDTO(creditoSalvo.getId());
        producer.sendCreditoEventoScore(creditoEventoScoreDTO);
        producer.sendCreditoEventoHistorico(creditoEventoHistoricoDTO);
        CreditoResponseDTO response = transformarEmResponse.transformarEmResponse(creditoSalvo);
    
        return response;
        
    }



    
}
