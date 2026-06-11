package Credito_Service.DTO;

import java.math.BigDecimal;

public class CreditoResponseDTO {

    private Long id;
    private BigDecimal salario;
    private BigDecimal limiteDeCredito;
    private BigDecimal limiteDisponivel;
    private Long quantidadeDeAtrasos;
    private Long quantidadeDeConsultas;


    public CreditoResponseDTO() {
    }


    public CreditoResponseDTO(Long id, BigDecimal salario, BigDecimal limiteDeCredito, BigDecimal limiteDisponivel,
            Long quantidadeDeAtrasos, Long quantidadeDeConsultas) {
        this.id = id;
        this.salario = salario;
        this.limiteDeCredito = limiteDeCredito;
        this.limiteDisponivel = limiteDisponivel;
        this.quantidadeDeAtrasos = quantidadeDeAtrasos;
        this.quantidadeDeConsultas = quantidadeDeConsultas;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public BigDecimal getSalario() {
        return salario;
    }


    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }


    public BigDecimal getLimiteDeCredito() {
        return limiteDeCredito;
    }


    public void setLimiteDeCredito(BigDecimal limiteDeCredito) {
        this.limiteDeCredito = limiteDeCredito;
    }


    public BigDecimal getLimiteDisponivel() {
        return limiteDisponivel;
    }


    public void setLimiteDisponivel(BigDecimal limiteDisponivel) {
        this.limiteDisponivel = limiteDisponivel;
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
    
}
