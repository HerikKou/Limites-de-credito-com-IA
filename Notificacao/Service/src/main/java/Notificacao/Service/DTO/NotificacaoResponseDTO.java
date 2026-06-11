package Notificacao.Service.DTO;

public class NotificacaoResponseDTO {
private Long id;
private Long idLlm;
private Long idcredito;
private String email;
private Long idLlmprocessado;
public NotificacaoResponseDTO(Long id, Long idLlm, Long idcredito, String email,Long idLlmprocessado) {
    this.id = id;
    this.idLlm = idLlm;
    this.idcredito = idcredito;
    this.email = email;
    this.idLlmprocessado = idLlmprocessado;
}
public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
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
public String getEmail() {
    return email;
}
public void setEmail(String email) {
    this.email = email;
}
public Long getIdLlmprocessado() {
    return idLlmprocessado;
}
public void setIdLlmprocessado(Long idLlmprocessado) {
    this.idLlmprocessado = idLlmprocessado;
}

}
