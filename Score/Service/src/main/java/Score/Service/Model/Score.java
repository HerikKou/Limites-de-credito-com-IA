package Score.Service.Model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;


@Entity
public class Score {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@NotNull(message = "O campo creditoId é obrigatório")
private Long creditoId;
@NotNull(message = "O campo historiaId é obrigatório")
private Long historicoId;
@NotNull(message = "O campo valorGasto é obrigatório")
private BigDecimal valorGasto;
@NotNull(message = "O campo quantidadeDeAtrasos é obrigatório")
private int quantidadeDeAtrasos;
@NotNull(message = "O campo limiteDeCredito é obrigatório")
private BigDecimal limiteDeCredito;
@NotNull(message = "O campo quantidadeDeConsultas é obrigatório")
private int quantidadeDeConsultas;
@NotNull(message = "O campo scorefinal é obrigatório")
private int scorefinal;
@NotNull(message = "O campo status é obrigatório")
private Status status;
private LocalDateTime tempodeHistorico;
private Long idCreditoProcessado;
private Long idHistoricoProcessado;

public Score() {}
public Score(Long creditoId, Long historicoId, BigDecimal valorGasto, int quantidadeDeAtrasos, BigDecimal limiteDeCredito, 
int quantidadeDeConsultas, int scorefinal, Status status,LocalDateTime tempoDeHistorico, Long idCreditoProcessado, Long idHistoricoProcessado) {
    this.creditoId = creditoId;
    this.historicoId = historicoId;
    this.valorGasto = valorGasto;
    this.quantidadeDeAtrasos = quantidadeDeAtrasos;
    this.limiteDeCredito = limiteDeCredito;
    this.quantidadeDeConsultas = quantidadeDeConsultas;
    this.scorefinal = scorefinal;
    this.status = status;
    this.idCreditoProcessado = idCreditoProcessado;
    this.idHistoricoProcessado = idHistoricoProcessado;}
public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public Long getCreditoId() {
    return creditoId;
}
public void setCreditoId(Long creditoId) {
    this.creditoId = creditoId;
}
public Long getHistoricoId() {
    return historicoId;
}
public void setHistoricoId(Long historicoId) {
    this.historicoId = historicoId;
}
public BigDecimal getValorGasto() {
    return valorGasto;
}
public void setValorGasto(BigDecimal valorGasto) {
    this.valorGasto = valorGasto;
}
public int getQuantidadeDeAtrasos() {
    return quantidadeDeAtrasos;
}
public void setQuantidadeDeAtrasos(int quantidadeDeAtrasos) {
    this.quantidadeDeAtrasos = quantidadeDeAtrasos;
}
public BigDecimal getLimiteDeCredito() {
    return limiteDeCredito;
}
public void setLimiteDeCredito(BigDecimal limiteDeCredito) {
    this.limiteDeCredito = limiteDeCredito;
}
public int getQuantidadeDeConsultas() {
    return quantidadeDeConsultas;
}
public void setQuantidadeDeConsultas(int quantidadeDeConsultas) {
    this.quantidadeDeConsultas = quantidadeDeConsultas;
}
public int getScorefinal() {
    return scorefinal;
}
public void setScorefinal(int scorefinal) {
    this.scorefinal = scorefinal;
}
public Status getStatus() {
    return status;
}
public void setStatus(Status status) {
    this.status = status;
}
public Long getIdCreditoProcessado() {
    return idCreditoProcessado;
}
public void setIdCreditoProcessado(Long idCreditoProcessado) {
    this.idCreditoProcessado = idCreditoProcessado;
}
public Long getIdHistoriaProcessada() {
    return idHistoricoProcessado;
}
public void setIdHistoriaProcessada(Long idHistoricoProcessado) {
    this.idHistoricoProcessado = idHistoricoProcessado;
}
public LocalDateTime getTempodeHistorico() {
    return tempodeHistorico;
}
public void setTempodeHistorico(LocalDateTime tempodeHistorico) {
    this.tempodeHistorico = tempodeHistorico;
}

}
