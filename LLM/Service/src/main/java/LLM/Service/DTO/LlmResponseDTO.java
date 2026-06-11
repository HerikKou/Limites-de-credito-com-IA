package LLM.Service.DTO;

public class LlmResponseDTO {
    private Long id;
    private Long creditoid;
    private Long idScoreid;
    private String cenario;
    public LlmResponseDTO(Long id, Long idScoreid,Long creditoid, String cenario) {
        this.id = id;
        this.creditoid = creditoid;
        this.cenario = cenario;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public Long getIdScoreid() {
        return idScoreid;
    }
    public void setIdScoreid(Long idScoreid) {
        this.idScoreid = idScoreid;
    }
    
}
