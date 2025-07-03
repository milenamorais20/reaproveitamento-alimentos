package sistema.reaproveitamento.alimentos.project.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sistema.reaproveitamento.alimentos.project.model.Usuario;
import sistema.reaproveitamento.alimentos.project.model.dto.UsuarioDTO;
import sistema.reaproveitamento.alimentos.project.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        try {
            usuarioService.createUsuario(usuarioDTO);
            return ResponseEntity.ok("Cadastro criado com sucesso!");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Email já está em uso.");
        }
    }

    @GetMapping
    public List<Usuario> getAll(){
        try {
            return usuarioService.getAllUsuarios();

        } catch (Exception e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @GetMapping("/usuario/{id}")
    public Usuario getById(@PathVariable("id") Integer id){
        try {
            return usuarioService.getUsuarioById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@Valid @PathVariable("id") Integer id,@RequestBody  UsuarioDTO ongDTO){
        try {
            usuarioService.updateUsuario(id, ongDTO);
            return ResponseEntity.ok("Cadastro atualizado com sucesso! ");
        } catch (Exception e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id){
        try {
            usuarioService.deleteUsuario(id);
            return ResponseEntity.ok("Cadastro deletado com sucesso!");
        } catch (Exception e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAll(){
        try {
            usuarioService.deleteAllUsuarios();
            return ResponseEntity.ok("Todos os cadastros foram deletados do banco de dados com sucesso!");
        } catch (Exception e) {
            throw new RuntimeException(e.getCause());
        }
    }
}
