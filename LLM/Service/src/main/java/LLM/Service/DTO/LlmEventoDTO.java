package LLM.Service.DTO;

public class LlmEventoDTO {
    private Long idLlm;
    private Long creditoid;
    private String cenario;
    public LlmEventoDTO(){}
    public LlmEventoDTO(Long idLlm, Long creditoid, String cenario) {
        this.idLlm = idLlm;
        this.creditoid = creditoid;
        this.cenario = cenario;
    }
    public Long getIdLlm() {
        return idLlm;
    }
    public void setIdLlm(Long idLlm) {
        this.idLlm = idLlm;
    }
    public Long getCreditoid() {
        return creditoid;
    }
    public void setCreditoid(Long creditoid) {
        this.creditoid = creditoid;
    }
    public String getCenario() {
        return cenario;
    }
    public void setCenario(String cenario) {
        this.cenario = cenario;
    }
    
}
