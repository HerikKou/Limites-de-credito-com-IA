package Score.Service.DTO;

import Score.Service.Model.Status;

public class ScoreEventoDTO {
private Long idScore;
private Long creditoId;
 private Status status;
    public ScoreEventoDTO() {
    }
    public ScoreEventoDTO(Long idScore,Long creditoId, Status status) {
        this.idScore = idScore;
        this.creditoId  = creditoId;
        this.status = status;
    }
    public Long getIdScore() {
        return idScore;
    }
    public void setIdScore(Long idScore) {
        this.idScore = idScore;
    }
    
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public Long getCreditoId() {
        return creditoId;
    }
    public void setCreditoId(Long creditoId) {
        this.creditoId = creditoId;
    }
    
}
