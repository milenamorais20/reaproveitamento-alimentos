package sistema.reaproveitamento.alimentos.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistema.reaproveitamento.alimentos.project.model.Usuario;
import sistema.reaproveitamento.alimentos.project.model.dto.UsuarioDTO;
import sistema.reaproveitamento.alimentos.project.repository.UsuarioRepository;
import sistema.reaproveitamento.alimentos.project.service.UsuarioService;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    @Override
    public Usuario createUsuario(UsuarioDTO usuarioDTO) {
        try {
            Usuario usuario = new Usuario();

            usuario.setNome(usuarioDTO.getNome());
            usuario.setEmail(usuarioDTO.getEmail());

            repository.save(usuario);
            return usuario;
        } catch (Exception e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public Usuario getUsuarioById(Integer id) {
       try {
           return repository.findById(id).get();
       } catch (Exception e) {
           throw new RuntimeException(e.getCause());
       }
    }

    @Override
    public void updateUsuario(Integer id, UsuarioDTO usuarioDTO) {
        Optional<Usuario> usuario = repository.findById(id);
        if (usuario.isPresent()){
            Usuario usuarioUpdate = usuario.get();
            usuarioUpdate.setNome(usuarioDTO.getNome());
            usuarioUpdate.setEmail(usuarioDTO.getEmail());
            repository.save(usuarioUpdate);
        }else {
            throw new RuntimeException("Usuario inexistente no banco de dados. Por favor, insira um id válido.");
        }
    }

    @Override
    public void deleteUsuario(Integer id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public void deleteAllUsuarios() {
        try {
            repository.deleteAll();
        } catch (Exception e) {
            throw new RuntimeException(e.getCause());
        }
    }
}
