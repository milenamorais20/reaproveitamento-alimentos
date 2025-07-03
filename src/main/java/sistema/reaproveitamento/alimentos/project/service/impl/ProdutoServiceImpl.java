package sistema.reaproveitamento.alimentos.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistema.reaproveitamento.alimentos.project.model.Produto;
import sistema.reaproveitamento.alimentos.project.model.dto.ProdutoDTO;
import sistema.reaproveitamento.alimentos.project.repository.ProdutoRepository;
import sistema.reaproveitamento.alimentos.project.service.ProdutoService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    @Override
    public List<Produto> createManyProdutos(List<Produto> listaProdutos) {
        try {
            List<Produto> produtos = new ArrayList<>();
            produtos.addAll(listaProdutos);
            repository.saveAll(produtos);
            return produtos;
        } catch (Exception e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public void updateProduto(int id, ProdutoDTO produtoDTO) {
        try {
            Optional<Produto> produto = repository.findById(id);

            if (produto.isPresent()) {
                Produto produtoUpdate = produto.get();
                produtoUpdate.setDataValidade(produtoDTO.getDataValidade());
                produtoUpdate.setNome(produtoDTO.getNome());
                produtoUpdate.setQuantidadeEmKilos(produtoDTO.getQuantidadeEmKilos());
                produtoUpdate.setReaproveitavel(produtoDTO.getReaproveitavel());
                repository.save(produtoUpdate);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public Produto getProduto(int id) {
        changeReaproveitavel();
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado."));
    }

    @Override
    public List<Produto> getAllProdutos() {
        try {
            changeReaproveitavel();
            return repository.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteProduto(int id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public void deleteAllProdutos() {
        try {
            repository.deleteAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void changeReaproveitavel(){
        try {
            List<Produto> todosProdutos = repository.findAll();
            LocalDate hoje = LocalDate.now();
            for (Produto produto: todosProdutos){
                if(produto.getDataValidade().isBefore(hoje)){
                    produto.setReaproveitavel(false);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getCause());
        }
    }
}
