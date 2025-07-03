package sistema.reaproveitamento.alimentos.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sistema.reaproveitamento.alimentos.project.model.ItemRetirada;

@Repository
public interface ItemRetiradaRepository extends JpaRepository<ItemRetirada, Integer> {
}
