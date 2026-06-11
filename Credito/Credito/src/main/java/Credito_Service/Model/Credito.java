package Credito_Service.Model;

import java.math.BigDecimal;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.GenerationType;
@Entity
public class Credito {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "O salário é obrigatório")
    private BigDecimal salario;
    @NotNull(message = "O limite de crédito é obrigatório")
    private BigDecimal limiteDeCredito;
    @NotNull(message = "O limite disponível é obrigatório")
    private BigDecimal limiteDisponivel;
    @NotNull(message = "A quantidade de atrasos é obrigatória")
    private Long quantidadeDeAtrasos;
    @NotNull(message = "A quantidade de consultas é obrigatória")
    private Long quantidadeDeConsultas;


        public Credito() {
            }

    public Credito(Long id, BigDecimal salario, BigDecimal limiteDeCredito, BigDecimal limiteDisponivel,
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
