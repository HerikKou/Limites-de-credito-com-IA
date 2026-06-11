package Historico_Service.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Historico_Service.Model.Historico;

public interface HistoricoRepository  extends JpaRepository<Historico, Long> {

    boolean existsByIdCredito(Long jaProcessado);

    @Query("SELECT h FROM Historico h WHERE h.credito.id = :idCredito")
    Historico findByCreditoId(Long idCredito);

    @Query("SELECT h FROM Historico h WHERE h.credito.id = :idCredito")
    List<Historico> findAllByCreditoId(Long idCredito);

   

}