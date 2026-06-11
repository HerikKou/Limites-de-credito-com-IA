package Notificacao.Service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Notificacao.Service.Model.Notificacao;

public interface NotificacaoRepository extends JpaRepository<Notificacao, Long>{
    boolean existsByIdLlm(Long idLlm);
}
