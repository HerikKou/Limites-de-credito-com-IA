package Historico_Service.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class HistoricoResponseDTO {

    private Long id;
    private Long idCredito;
    private String estabelecimento;
    private String descricao;
    private BigDecimal valor;
    private LocalDateTime data = LocalDateTime.now();
    public HistoricoResponseDTO(){}
    public HistoricoResponseDTO(Long id, Long idCredito, String estabelecimento, String descricao, BigDecimal valor,
            LocalDateTime data) {
        this.id = id;
        this.idCredito = idCredito;
        this.estabelecimento = estabelecimento;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
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
    public String getEstabelecimento() {
        return estabelecimento;
    }
    public void setEstabelecimento(String estabelecimento) {
        this.estabelecimento = estabelecimento;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    public LocalDateTime getData() {
        return data;
    }
    public void setData(LocalDateTime data) {
        this.data = data;
    }

   

}
