package LLM.Service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import LLM.Service.Model.Llm;

public interface LlmRepository extends JpaRepository<Llm, Long>{
    boolean existyByCreditoId(Long creditoid);
    boolean existyByScoreId(Long scoreId);
}
