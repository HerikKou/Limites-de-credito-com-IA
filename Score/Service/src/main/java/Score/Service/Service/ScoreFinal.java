package Score.Service.Service;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import Score.Service.DTO.ScoreResponse;
import Score.Service.Model.Status;

@Component
public class ScoreFinal {
    private final CalcularCadaTipo calcular;
    

    public ScoreFinal(CalcularCadaTipo calcular) {
        this.calcular = calcular;
    }


    public int calcularScoreFinal(ScoreResponse score){
        BigDecimal totalGasto = calcular.CalcularTotalGasto(score);
        int historico = calcular.CalcularTempoDeHistorico(score);
        int consultas = calcular.CompararQuantidadeDeConsultas(score);
        int parcelas = calcular.CompararQuantidadeDeAtrasosDeParcelas(score);
        int conversao = totalGasto.intValue();
       
        return conversao + historico + consultas + parcelas ;
    }


    public Status validarScore(ScoreResponse score){
        int  scorecredito = calcularScoreFinal(score);
        if(scorecredito >= 60){
            return Status.ALTO;
        }
        return Status.BAIXO;
    }
}
