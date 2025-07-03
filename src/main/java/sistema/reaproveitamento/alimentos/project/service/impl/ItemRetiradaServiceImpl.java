package sistema.reaproveitamento.alimentos.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistema.reaproveitamento.alimentos.project.model.ItemRetirada;
import sistema.reaproveitamento.alimentos.project.model.dto.ItemRetiradaDTO;
import sistema.reaproveitamento.alimentos.project.repository.ItemRetiradaRepository;
import sistema.reaproveitamento.alimentos.project.repository.ProdutoRepository;
import sistema.reaproveitamento.alimentos.project.service.ItemRetiradaService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemRetiradaServiceImpl implements ItemRetiradaService {
    @Autowired
    private ItemRetiradaRepository itensRetiradaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public void createItem(ItemRetiradaDTO itemRetiradaDTO) {
        try {
            ItemRetirada itemRetirada = new ItemRetirada();
            itemRetirada.setProduto(produtoRepository.findById(itemRetiradaDTO.getProdutoId()).get());
            itemRetirada.setQuantidadeRetirada(itemRetiradaDTO.getQuantidadeRetirada());
            itensRetiradaRepository.save(itemRetirada);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível adicionar o item. Causa" + e.getCause());
        }
    }

    @Override
    public List<String> getItems() {
        try {
            List<String> itensFormatados =  new ArrayList<>();

            for (ItemRetirada item: itensRetiradaRepository.findAll()){
                String itemFormatado = "";

                String nomeProduto = item.getProduto().getNome();
                LocalDate dataValidadeProduto = item.getProduto().getDataValidade();
                Double quantidadeRetirada = item.getQuantidadeRetirada();

                itemFormatado = "Nome do Produto: " +  nomeProduto + " | Validade: " + dataValidadeProduto + " | Quantidade retirada: " + quantidadeRetirada;
                itensFormatados.add(itemFormatado);
            }

            return itensFormatados;
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível exibir os itens. Causa" + e.getCause());
        }
    }

    @Override
    public void deleteItem(int id) {
        try {
            itensRetiradaRepository.deleteById(id);

        } catch (Exception e) {
            throw new RuntimeException("Error. Causa"+e.getCause());
        }

    }
}
