package sistema.reaproveitamento.alimentos.project.service;

import sistema.reaproveitamento.alimentos.project.model.Produto;
import sistema.reaproveitamento.alimentos.project.model.dto.ProdutoDTO;

import java.util.List;

public interface ProdutoService {
    List<Produto> createManyProdutos(List<Produto> listaProdutos);
    void updateProduto(int id, ProdutoDTO produtoDTO);
    Produto getProduto(int id);
    List<Produto> getAllProdutos();
    void deleteProduto(int id);
    void deleteAllProdutos();
}
