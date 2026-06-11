package LLM.Service.Model;

import groovy.transform.Generated;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Llm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Long creditoId;
    @NotNull
    private Long idScore;
    @NotNull
    private String cenario;
    public Llm(){}
    public Llm(Long id, Long creditoId, Long idScore, String cenario) {
        this.id = id;
        this.creditoId = creditoId;
        this.idScore = idScore;
        this.cenario = cenario;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getCreditoId() {
        return creditoId;
    }
    public void setCreditoId(Long creditoId) {
        this.creditoId = creditoId;
    }
    public Long getIdScore() {
        return idScore;
    }
    public void setIdScore(Long idScore) {
        this.idScore = idScore;
    }
    public String getCenario() {
        return cenario;
    }
    public void setCenario(String cenario) {
        this.cenario = cenario;
    }
    
    
}
