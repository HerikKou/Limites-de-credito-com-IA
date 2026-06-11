package Score.Service.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class HistoricoCriadoEventoDTO {
private Long historicoId;
private Long creditoId;
private BigDecimal valorGasto;
private LocalDateTime data;

public HistoricoCriadoEventoDTO() {
}



public HistoricoCriadoEventoDTO(Long historicoId,Long creditoId, BigDecimal valorGasto, LocalDateTime data) {
    this.historicoId = historicoId;
    this.creditoId = creditoId;
    this.valorGasto = valorGasto;
    this.data = data;
}



public Long getHistoricoId() {
    return historicoId;
}



public void setHistoricoId(Long historicoId) {
    this.historicoId = historicoId;
}

public Long getCreditoId() {
    return creditoId;
}



public void setCreditoId(Long creditoId) {
    this.creditoId = creditoId;
}

public BigDecimal getValorGasto() {
    return valorGasto;
}



public void setValorGasto(BigDecimal valorGasto) {
    this.valorGasto = valorGasto;
}



public LocalDateTime getData() {
    return data;
}



public void setData(LocalDateTime data) {
    this.data = data;
}



}
