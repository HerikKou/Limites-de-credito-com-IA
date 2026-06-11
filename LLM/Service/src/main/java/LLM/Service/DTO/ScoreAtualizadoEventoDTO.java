package LLM.Service.DTO;
import LLM.Service.Status.*;
public class ScoreAtualizadoEventoDTO {

    private Long idScore;
    private Long creditoId;
    private Status status ;
    public ScoreAtualizadoEventoDTO(Long idScore, Long creditoId, Status status) {
        this.idScore = idScore;
        this.creditoId = creditoId;
        this.status = status;
    }
    public Long getIdScore() {
        return idScore;
    }
    public void setIdScore(Long idScore) {
        this.idScore = idScore;
    }
    public Long getCreditoId() {
        return creditoId;
    }
    public void setCreditoId(Long creditoId) {
        this.creditoId = creditoId;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    
}
