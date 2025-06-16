package sistema.reaproveitamento.alimentos.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistema.reaproveitamento.alimentos.project.model.Produto;
import sistema.reaproveitamento.alimentos.project.model.dto.ProdutoDTO;
import sistema.reaproveitamento.alimentos.project.repository.ProdutoRepository;
import sistema.reaproveitamento.alimentos.project.service.ProdutoService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    @Override
    public void create(ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        produto.setDataValidade(produtoDTO.getDataValidade());
        produto.setNome(produtoDTO.getNome());
        produto.setQuantidadeEmKilos(produtoDTO.getQuantidadeEmKilos());
        produto.setReaproveitavel(produtoDTO.getReaproveitavel());
        repository.save(produto);
    }

    @Override
    public void update(int id, ProdutoDTO produtoDTO) {
        changeReaproveitavel();
        Optional<Produto> produto = repository.findById(id);

        if (produto.isPresent()){
            Produto produtoUpdate = produto.get();
            produtoUpdate.setDataValidade(produtoDTO.getDataValidade());
            produtoUpdate.setNome(produtoDTO.getNome());
            produtoUpdate.setQuantidadeEmKilos(produtoDTO.getQuantidadeEmKilos());
            produtoUpdate.setReaproveitavel(produtoDTO.getReaproveitavel());
            repository.save(produtoUpdate);

        }else {
            throw new RuntimeException("Código inexistente.");
        }
    }

    @Override
    public Produto get(int id) {
        changeReaproveitavel();
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado."));
    }

    @Override
    public List<Produto> getAll() {
        changeReaproveitavel();
        return repository.findAll();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    public void changeReaproveitavel(){
        List<Produto> todosProdutos = repository.findAll();
        LocalDate hoje = LocalDate.now();
        for (Produto produto: todosProdutos){
            if(produto.getDataValidade().isBefore(hoje)){
                produto.setReaproveitavel(false);
            }
        }
    }
}
