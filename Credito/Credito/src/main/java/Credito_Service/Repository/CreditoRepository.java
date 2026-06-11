package Credito_Service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Credito_Service.Model.Credito;

public interface CreditoRepository extends JpaRepository<Credito, Long> {

}
