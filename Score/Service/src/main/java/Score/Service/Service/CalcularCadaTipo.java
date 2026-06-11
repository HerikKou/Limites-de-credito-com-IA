package Score.Service.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Locale;

import org.springframework.stereotype.Component;

import Score.Service.DTO.ScoreResponse;
import Score.Service.Model.Score;

@Component
public class CalcularCadaTipo {


public BigDecimal CalcularTotalGasto(ScoreResponse score){
    
   
   BigDecimal percentual = score.getValorGasto().divide(score.getLimiteDeCredito(),4, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));
   if(percentual.compareTo(BigDecimal.valueOf(70)) > 0){
    return BigDecimal.valueOf(30);
}
return BigDecimal.ZERO;
    
}

public int CalcularTempoDeHistorico(ScoreResponse score){
LocalDateTime hoje = LocalDateTime.now();
LocalDateTime tempo = hoje.minusDays(365);
if(score.getTempoDeHistorico() == null || score.getTempoDeHistorico().isBefore(tempo) ){
    return 30;
}
return 0;
}

public int CompararQuantidadeDeConsultas(ScoreResponse score){
    if( score.getQuantidadeDeConsultas() > 3){
        return 30;
    }
    return 0;
}

public int CompararQuantidadeDeAtrasosDeParcelas(ScoreResponse score){
    if(score.getQuantidadeDeAtrasos() > 3){
        return 20;

    }
    return 0;
}

}











