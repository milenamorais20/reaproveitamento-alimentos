package sistema.reaproveitamento.alimentos.project.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sistema.reaproveitamento.alimentos.project.model.Ong;
import sistema.reaproveitamento.alimentos.project.model.dto.OngDTO;
import sistema.reaproveitamento.alimentos.project.service.OngService;

import java.util.List;

@RestController
@RequestMapping("/ongs")
public class OngController {
    @Autowired
    private OngService ongService;

    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody OngDTO ongDTO){
        ongService.create(ongDTO);
        return ResponseEntity.ok("Cadastro criado com sucesso! ");
    }

    @GetMapping
    public List<Ong> getAll(){
        return ongService.getAll();
    }

    @GetMapping("/ong/{id}")
    public Ong getById(@PathVariable("id") Integer id){
        return ongService.getById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable("id") Integer id, OngDTO ongDTO){
        ongService.update(id, ongDTO);
        return ResponseEntity.ok("Cadastro atualizado com sucesso! ");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id){
        ongService.delete(id);
        return ResponseEntity.ok("Cadastro deletado com sucesso!");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAll(){
        ongService.deleteAll();
        return ResponseEntity.ok("Todos os cadastros foram deletados do banco de dados com sucesso!");
    }
}
