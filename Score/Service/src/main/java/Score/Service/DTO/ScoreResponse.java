package Score.Service.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import Score.Service.Model.Status;

public class ScoreResponse {
   
private Long creditoId;

private Long historicoId;

private BigDecimal valorGasto;

private int quantidadeDeAtrasos;

private BigDecimal limiteDeCredito;

private int quantidadeDeConsultas;

private int scorefinal;
private Status status;
private LocalDateTime tempoDeHistorico;
private Long idCreditoProcessado;
private Long idHistoriaProcessada;
public ScoreResponse(){}

public ScoreResponse(Long creditoId, Long historicoId,  BigDecimal valorGasto, 
int quantidadeDeAtrasos, BigDecimal limiteDeCredito, 
int quantidadeDeConsultas, int scorefinal, Status status,LocalDateTime tempoDeHistorico, Long idCreditoProcessado, Long idHistoriaProcessada){
    this.creditoId = creditoId;
    this.historicoId = historicoId;
    this.valorGasto = valorGasto;
    this.quantidadeDeAtrasos = quantidadeDeAtrasos;
    this.limiteDeCredito = limiteDeCredito;
    this.quantidadeDeConsultas = quantidadeDeConsultas;
    this.scorefinal = scorefinal;
    this.status = status;
    this.tempoDeHistorico = tempoDeHistorico;
    this.idCreditoProcessado = idCreditoProcessado;
    this.idHistoriaProcessada = idHistoriaProcessada;
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
    return idHistoriaProcessada;
}
public void setIdHistoriaProcessada(Long idHistoriaProcessada) {
    this.idHistoriaProcessada = idHistoriaProcessada;
}

public LocalDateTime getTempoDeHistorico() {
    return tempoDeHistorico;
}

public void setTempoDeHistorico(LocalDateTime tempoDeHistorico) {
    this.tempoDeHistorico = tempoDeHistorico;
}
  

    
}
