package Score.Service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Score.Service.Model.Score;
import java.util.List;


public interface ScoreRepository extends JpaRepository<Score , Long>{
    boolean existsByCreditoId(Long idCreditoProcessado);
    boolean existsByHistoricoId(Long idHistoricoProcessado);
     Score   findByCreditoId(Long creditoId);
    Score  findByHistoricoId(Long historicoId);
}
