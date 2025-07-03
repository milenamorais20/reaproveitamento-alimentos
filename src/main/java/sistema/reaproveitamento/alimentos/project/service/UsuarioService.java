package sistema.reaproveitamento.alimentos.project.service;

import sistema.reaproveitamento.alimentos.project.model.Usuario;
import sistema.reaproveitamento.alimentos.project.model.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioService {
    Usuario createUsuario(UsuarioDTO ongDTO);
    List<Usuario> getAllUsuarios();
    Usuario getUsuarioById(Integer id);
    void updateUsuario(Integer id, UsuarioDTO ongDTO);
    void deleteUsuario(Integer id);
    void deleteAllUsuarios();
}
