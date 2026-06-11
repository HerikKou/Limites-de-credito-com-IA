package Notificacao.Service.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Notificacao {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private Long idLlm;
private Long idcredito;
private String email;
private String cenario;
public Notificacao(Long id, Long idLlm, Long idcredito, String email, String cenario) {
    this.id = id;
    this.idLlm = idLlm;
    this.idcredito = idcredito;
    this.email = email;
    this.cenario = cenario;
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
public String getCenario() {
    return cenario;
}
public void setCenario(String cenario) {
    this.cenario = cenario;
}
}
