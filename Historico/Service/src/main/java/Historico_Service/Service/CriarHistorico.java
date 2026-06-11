package Historico_Service.Service;

import org.slf4j.*;
import org.springframework.stereotype.Service;

import Historico_Service.DTO.HistoricoRequestDTO;
import Historico_Service.DTO.HistoricoResponseDTO;
import Historico_Service.Model.Historico;
import Historico_Service.Repository.HistoricoRepository;

@Service
public class CriarHistorico {

    private final Logger log = LoggerFactory.getLogger(CriarHistorico.class);
     private final HistoricoRepository repository ;
     private final TransformarEmModel model;
     private final TransformarEmResponse response;
     public CriarHistorico(HistoricoRepository repository, TransformarEmModel model,
            TransformarEmResponse response) {
        this.repository = repository;
        this.model = model;
        this.response = response;
     }
     
     public HistoricoResponseDTO criar(HistoricoRequestDTO request, Long idCredito){
         
        Historico historico = repository.findByCreditoId(idCredito);
         if(historico == null){
               log.error("Historico não encontrado para o idCredito: {}", idCredito);
               throw new RuntimeException("Historico não encontrado");
         }
          log.info("Criando Historico para idCredito: {}", idCredito);
      historico =
        model.transformar(request, historico);

         Historico historicoSalvo = repository.save(historico);
         
         return response.transformarResponse(historicoSalvo);

     }
}
