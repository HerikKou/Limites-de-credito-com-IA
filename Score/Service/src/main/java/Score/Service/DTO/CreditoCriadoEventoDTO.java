package Score.Service.DTO;

import java.math.BigDecimal;

public class CreditoCriadoEventoDTO {

    private Long creditoId;
    private BigDecimal limiteDeCredito;
    private int quantidadeDeConsultas;
    private int quantidadeDeAtrasos;

    public CreditoCriadoEventoDTO() {
    }

    public CreditoCriadoEventoDTO(Long creditoId, BigDecimal limiteDeCredito, int quantidadeDeConsultas, int quantidadeDeAtrasos) {
        this.creditoId = creditoId;
        this.limiteDeCredito = limiteDeCredito;
        this.quantidadeDeConsultas = quantidadeDeConsultas;
        this.quantidadeDeAtrasos = quantidadeDeAtrasos;
    }

    public Long getCreditoId() {
        return creditoId;
    }

    public void setCreditoId(Long creditoId) {
        this.creditoId = creditoId;
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

    public int getQuantidadeDeAtrasos() {
        return quantidadeDeAtrasos;
    }

    public void setQuantidadeDeAtrasos(int quantidadeDeAtrasos) {
        this.quantidadeDeAtrasos = quantidadeDeAtrasos;
    }
    
}
