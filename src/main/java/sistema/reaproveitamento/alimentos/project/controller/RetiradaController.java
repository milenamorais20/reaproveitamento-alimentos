package sistema.reaproveitamento.alimentos.project.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sistema.reaproveitamento.alimentos.project.model.Retirada;
import sistema.reaproveitamento.alimentos.project.model.dto.RetiradaDTO;
import sistema.reaproveitamento.alimentos.project.service.RetiradaService;

import java.util.List;

@RestController
@RequestMapping("/retiradas")
public class RetiradaController {
    @Autowired
    private RetiradaService retiradaService;

    @PostMapping
    public ResponseEntity<String> createRetirada(@Valid @RequestBody RetiradaDTO retirada){
        try {
            retiradaService.createRetirada(retirada);
            return ResponseEntity.ok("Retirada realizada com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Não foi possível realizar a retirada. Entre em contato com o suporte.");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Retirada> getRetirada(@PathVariable("id") int id){
        try {
            return ResponseEntity.ok(retiradaService.getRetirada(id));
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível exibir essa a retirada. Entre em contato com o suporte.");
        }
    }

    @GetMapping
    public ResponseEntity<List<String>> getAllRetiradas(){
        try {
            return ResponseEntity.ok(retiradaService.getAllRetiradas());
        } catch (Exception e) {
            throw new RuntimeException("Houve um erro. Entre em contato com o suporte.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRetirada(@PathVariable("id") int id){
        try {
            retiradaService.deleteRetirada(id);
            return ResponseEntity.ok("Deletado com sucesso");
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível deletar essa a retirada. Entre em contato com o suporte.");
        }
    }
}