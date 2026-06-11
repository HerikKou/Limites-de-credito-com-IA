package Historico_Service.Model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Historico {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@NotNull(message = "O id do crédito não pode ser nulo")
private Long idCredito;
@NotNull(message = "A descrição não pode ser nula")
private String descricao;
@NotNull(message = "A data não pode ser nula")
private LocalDateTime data;
@NotNull(message = "O valor gasto não pode ser nulo")
private BigDecimal valorGasto;
@NotNull(message = "O estabelecimento não pode ser nulo")
private String estabelecimento;
private Long jaProcessado;
public Historico(){}
public Historico(Long idCredito, String descricao, LocalDateTime data, BigDecimal valorGasto, String estabelecimento, Long jaProcessado) {
    this.idCredito = idCredito;
    this.descricao = descricao;
    this.data = data;
    this.valorGasto = valorGasto;
    this.estabelecimento = estabelecimento;
    this.jaProcessado = jaProcessado;
}
public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public Long getIdCredito() {
    return idCredito;
}
public void setIdCredito(Long idCredito) {
    this.idCredito = idCredito;
}
public String getDescricao() {
    return descricao;
}
public void setDescricao(String descricao) {
    this.descricao = descricao;
}
public LocalDateTime getData() {
    return data;
}
public void setData(LocalDateTime data) {
    this.data = data;
}
public BigDecimal getValorGasto() {
    return valorGasto;
}
public void setValorGasto(BigDecimal valorGasto) {
    this.valorGasto = valorGasto;
}
public String getEstabelecimento() {
    return estabelecimento;
}
public void setEstabelecimento(String estabelecimento) {
    this.estabelecimento = estabelecimento;
}
public Long getJaProcessado() {
    return jaProcessado;


}public void setJaProcessado(Long jaProcessado) {
    this.jaProcessado = jaProcessado;}



}
