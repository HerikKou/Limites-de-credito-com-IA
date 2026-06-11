package Historico_Service.DTO;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;

public class HistoricoRequestDTO {
    @NotNull(message = "O campo estabelecimento é obrigatório")
    private String estabelecimento;
    @NotNull(message = "O campo descricao é obrigatório")
    private String descricao;
    @NotNull(message = "O campo valorGasto é obrigatório")
    private BigDecimal valorGasto;

    public HistoricoRequestDTO() {
    }

    public HistoricoRequestDTO(String estabelecimento, String descricao, BigDecimal valorGasto) {
        this.estabelecimento = estabelecimento;
        this.descricao = descricao;
        this.valorGasto = valorGasto;
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

    public BigDecimal getValorGasto() {
        return valorGasto;
    }

    public void setValorGasto(BigDecimal valorGasto) {
        this.valorGasto = valorGasto;
    }

    

}
