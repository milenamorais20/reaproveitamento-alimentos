package sistema.reaproveitamento.alimentos.project.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sistema.reaproveitamento.alimentos.project.model.Produto;
import sistema.reaproveitamento.alimentos.project.model.dto.ProdutoDTO;
import sistema.reaproveitamento.alimentos.project.service.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody ProdutoDTO produtoDTO){
        produtoService.create(produtoDTO);
        return ResponseEntity.ok("Produto criado com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable("id") int id,@Valid @RequestBody ProdutoDTO produtoDTO){
        produtoService.update(id, produtoDTO);
        return ResponseEntity.ok("Produto atualizado com sucesso!");
    }

    @GetMapping("/produto/{id}")
    public ResponseEntity<Produto> get(@PathVariable("id") int id){
        return ResponseEntity.ok(produtoService.get(id));
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getAll(){
        return ResponseEntity.ok(produtoService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>delete(@PathVariable("id") int id){
        produtoService.delete(id);
        return ResponseEntity.ok("Produto deletado com sucesso! ");
    }

    @DeleteMapping
    public ResponseEntity<String>deleteAll(){
        produtoService.deleteAll();
        return ResponseEntity.ok("Produtos deletados com sucesso! ");
    }
}
