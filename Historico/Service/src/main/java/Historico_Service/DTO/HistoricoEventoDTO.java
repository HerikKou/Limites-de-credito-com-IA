package Historico_Service.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class HistoricoEventoDTO {
    private Long historicoid;
    private Long creditoId;
    private BigDecimal valorGasto;
    private LocalDateTime data;

    public HistoricoEventoDTO() {
    }
    public HistoricoEventoDTO(Long historicoid, Long creditoId,BigDecimal valorGasto, LocalDateTime data) {
        this.historicoid = historicoid;
        this.creditoId = creditoId;
        this.valorGasto = valorGasto;
        this.data = data;
    }
    public Long gethistoricoid() {
        return historicoid;
    }
    public void setIHistoricod(Long historicoid) {
        this.historicoid = historicoid;
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
