package sistema.reaproveitamento.alimentos.project.service;

import sistema.reaproveitamento.alimentos.project.model.dto.ItemRetiradaDTO;

import java.util.List;

public interface ItemRetiradaService {
    void createItem(ItemRetiradaDTO itemRetiradaDTO);
    List<String> getItems();
    void deleteItem(int id);
}
