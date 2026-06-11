package Credito_Service.DTO;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;

public class CreditoEventoScoreDTO {
   private Long id;
    @NotNull(message = "O limite de crédito é obrigatório")
    private BigDecimal limiteDeCredito;
    
    @NotNull(message = "A quantidade de atrasos é obrigatória")
    private Long quantidadeDeAtrasos;
    @NotNull(message = "A quantidade de consultas é obrigatória")
    private Long quantidadeDeConsultas;
    public CreditoEventoScoreDTO() {
    }
    public CreditoEventoScoreDTO(Long id, BigDecimal limiteDeCredito, Long quantidadeDeAtrasos, Long quantidadeDeConsultas) {
        this.id = id;
        this.limiteDeCredito = limiteDeCredito;
        
        this.quantidadeDeAtrasos = quantidadeDeAtrasos;
        this.quantidadeDeConsultas = quantidadeDeConsultas;
    }
    
    
    public BigDecimal getLimiteDeCredito() {
        return limiteDeCredito;
    }
    public void setLimiteDeCredito(BigDecimal limiteDeCredito) {
        this.limiteDeCredito = limiteDeCredito;
    }
   
    public Long getQuantidadeDeAtrasos() {
        return quantidadeDeAtrasos;
    }
    public void setQuantidadeDeAtrasos(Long quantidadeDeAtrasos) {
        this.quantidadeDeAtrasos = quantidadeDeAtrasos;
    }
    public Long getQuantidadeDeConsultas() {
        return quantidadeDeConsultas;
    }
    public void setQuantidadeDeConsultas(Long quantidadeDeConsultas) {
        this.quantidadeDeConsultas = quantidadeDeConsultas;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
}
