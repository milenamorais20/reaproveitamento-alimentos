package sistema.reaproveitamento.alimentos.project.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sistema.reaproveitamento.alimentos.project.model.dto.ItemRetiradaDTO;
import sistema.reaproveitamento.alimentos.project.service.ItemRetiradaService;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemRetiradaController {
    @Autowired
    private ItemRetiradaService itemRetiradaService;

    @PostMapping
    public void createItem(@Valid @RequestBody ItemRetiradaDTO itemRetiradaDTO){
        try {
            itemRetiradaService.createItem(itemRetiradaDTO);
        } catch (Exception e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @GetMapping
    public List<String> getItens(){
        try {
            return itemRetiradaService.getItems();
        } catch (Exception e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable("id") int id){
        itemRetiradaService.deleteItem(id);
    }
}
