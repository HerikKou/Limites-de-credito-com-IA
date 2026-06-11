package Notificacao.Service.DTO;

public class LlmCriadoEventoDTO {
private Long idLlm;
private Long idcredito;
private String cenario;
public LlmCriadoEventoDTO(Long idLlm, Long idcredito, String cenario) {
    this.idLlm = idLlm;
    this.idcredito = idcredito;
    this.cenario = cenario;
}
public Long getIdLlm() {
    return idLlm;
}
public void setIdLlm(Long idLlm) {
    this.idLlm = idLlm;
}
public Long getIdcredito() {
    return idcredito;
}
public void setIdcredito(Long idcredito) {
    this.idcredito = idcredito;
}
public String getCenario() {
    return cenario;
}
public void setCenario(String cenario) {
    this.cenario = cenario;
}


}
