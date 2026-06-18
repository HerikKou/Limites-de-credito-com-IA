package LLM.Service.Service;

import java.util.Map;

import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.template.st.StTemplateRenderer;
import org.springframework.stereotype.Service;

import LLM.Service.DTO.ScoreAtualizadoEventoDTO;

@Service
public class PromptService {
private final ProducerService producerService ;

public PromptService(ProducerService producerService) {
    this.producerService = producerService;
}


public String gerarPrompt(ScoreAtualizadoEventoDTO evento) {
    PromptTemplate promptTemplate = PromptTemplate.builder()
        .template("""
                Você é um especialista em análise de crédito.
                
                Status do score: {status}
                Explique em até 3 frases a situação financeira atual do cliente.
                """)
        .build();

    return promptTemplate.render(Map.of("status", evento.getStatus()));
}



}
