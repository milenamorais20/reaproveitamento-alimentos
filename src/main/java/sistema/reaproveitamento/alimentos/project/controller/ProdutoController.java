package sistema.reaproveitamento.alimentos.project.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<String> createMany(@Valid @RequestBody List<Produto> listaProdutos){
        try {
            produtoService.createManyProdutos(listaProdutos);
            return ResponseEntity.ok("Produtos adicionados com sucesso!");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Não foi possível adicionar a lista de produtos");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduto(@Valid @PathVariable("id") int id, @RequestBody ProdutoDTO produtoDTO){
        produtoService.updateProduto(id, produtoDTO);
        return ResponseEntity.ok("Produto atualizado com sucesso!");
    }

    @GetMapping("/produto/{id}")
    public ResponseEntity<Produto> get(@PathVariable("id") int id){
        return ResponseEntity.ok(produtoService.getProduto(id));
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getAll(){
        return ResponseEntity.ok(produtoService.getAllProdutos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>delete(@PathVariable("id") int id){
        produtoService.deleteProduto(id);
        return ResponseEntity.ok("Produto deletado com sucesso! ");
    }

    @DeleteMapping
    public ResponseEntity<String>deleteAll(){
        produtoService.deleteAllProdutos();
        return ResponseEntity.ok("Produtos deletados com sucesso! ");
    }
}
