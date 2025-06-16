package sistema.reaproveitamento.alimentos.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sistema.reaproveitamento.alimentos.project.model.Ong;

import java.util.List;

public interface OngRepository extends JpaRepository<Ong,Integer> {
    List<Ong> findAllByEmailIsNotNull();
}
