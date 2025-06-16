package sistema.reaproveitamento.alimentos.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sistema.reaproveitamento.alimentos.project.model.Produto;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    List<Produto> findByDataValidadeBetween(LocalDate inicio, LocalDate fim);
}
