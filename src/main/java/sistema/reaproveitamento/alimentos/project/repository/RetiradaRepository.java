package sistema.reaproveitamento.alimentos.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sistema.reaproveitamento.alimentos.project.model.Retirada;

public interface RetiradaRepository extends JpaRepository<Retirada, Integer> {
}
