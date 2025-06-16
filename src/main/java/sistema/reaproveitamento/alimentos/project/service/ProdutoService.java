package sistema.reaproveitamento.alimentos.project.service;

import sistema.reaproveitamento.alimentos.project.model.Produto;
import sistema.reaproveitamento.alimentos.project.model.dto.ProdutoDTO;

import java.util.List;

public interface ProdutoService {
    void create(ProdutoDTO produtoDTO);
    void update(int id, ProdutoDTO produtoDTO);
    Produto get(int id);
    List<Produto> getAll();
    void delete(int id);
    void deleteAll();
}
