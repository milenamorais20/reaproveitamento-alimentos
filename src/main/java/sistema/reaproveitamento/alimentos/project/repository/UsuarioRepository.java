package sistema.reaproveitamento.alimentos.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sistema.reaproveitamento.alimentos.project.model.Usuario;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    List<Usuario> findAllByEmailIsNotNull();
    boolean existsByEmail(String email);
}
