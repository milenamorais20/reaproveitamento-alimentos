package sistema.reaproveitamento.alimentos.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistema.reaproveitamento.alimentos.project.model.ItemRetirada;
import sistema.reaproveitamento.alimentos.project.model.Produto;
import sistema.reaproveitamento.alimentos.project.model.Retirada;
import sistema.reaproveitamento.alimentos.project.model.Usuario;
import sistema.reaproveitamento.alimentos.project.model.dto.RetiradaDTO;
import sistema.reaproveitamento.alimentos.project.repository.ItemRetiradaRepository;
import sistema.reaproveitamento.alimentos.project.repository.ProdutoRepository;
import sistema.reaproveitamento.alimentos.project.repository.RetiradaRepository;
import sistema.reaproveitamento.alimentos.project.repository.UsuarioRepository;
import sistema.reaproveitamento.alimentos.project.service.RetiradaService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class RetiradaServiceImpl implements RetiradaService {
    @Autowired
    private RetiradaRepository retiradaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ItemRetiradaRepository itemRetiradaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public void createRetirada(RetiradaDTO retiradaDTO) {
        try {
            Retirada novaRetirada = new Retirada();
            List<ItemRetirada> itensRetirada = new ArrayList<>();
            ItemRetirada itemRetirada = new ItemRetirada();

            Usuario usuarioById = usuarioRepository.findById(retiradaDTO.getUsuarioId()).orElseThrow(() -> new RuntimeException("Usuário não encontrado. Insira um ID válido"));
            Produto produto = produtoRepository.findById(retiradaDTO.getProdutoId()).get();

            itemRetirada.setProduto(produto);
            itemRetirada.setQuantidadeRetirada(retiradaDTO.getQuantidadeRetirada());

            itensRetirada.add(itemRetirada);

            novaRetirada.setUsuario(usuarioById);
            novaRetirada.setItens(itensRetirada);

            itemRetiradaRepository.save(itemRetirada);
            retiradaRepository.save(novaRetirada);

            Double quantidadeRetirada = retiradaDTO.getQuantidadeRetirada();

            produto.setQuantidadeEmKilos(produto.getQuantidadeEmKilos() - quantidadeRetirada);
            produtoRepository.save(produto);

        } catch (Exception e) {
            throw new RuntimeException("Não foi possível realizar a retirada. Entre em contato com o suporte. Causa: "+e.getCause());
        }
    }

    @Override
    public Retirada getRetirada(int id) {
        try {
            return retiradaRepository.findById(id).get();
        } catch (Exception e) {
            throw new RuntimeException("Houve um erro na exibição da retirada. Entre em contato com o suporte. Causa: "+e);
        }

    }

    @Override
    public List<String> getAllRetiradas() {
        try {
            List<Retirada> retiradaRepositoryAll = retiradaRepository.findAll();

            List<String> retornoFormatado = new ArrayList<>();
            for(Retirada retirada: retiradaRepositoryAll) {
                Integer retiradaId = retirada.getId();
                String usuarioRetirada = retirada.getUsuario().getNome();
                Iterator<ItemRetirada> iterator = retirada.getItens().iterator();

                retornoFormatado.add("ID: " + retiradaId + " | Usuário " + usuarioRetirada);
                while (iterator.hasNext()) {
                    String item = "";

                    ItemRetirada itemNext = iterator.next();
                    String nomeProduto = itemNext.getProduto().getNome();
                    Boolean reaproveitavelProduto = itemNext.getProduto().getReaproveitavel();
                    Double quantidadeRetiradaProduto = itemNext.getQuantidadeRetirada();

                    item = "Produto: " + nomeProduto + ", Reaproveitável? " + reaproveitavelProduto + ", Quantidade Retira: " + quantidadeRetiradaProduto;
                    retornoFormatado.add(" | Item: " + item);
                }
            }
            return retornoFormatado;
        } catch (Exception e) {
            throw new RuntimeException("Houve um erro na exibição das retiradas. Entre em contato com o suporte. Causa: "+e.getCause());
        }
    }

    @Override
    public String deleteRetirada(int id) {
        try{
            retiradaRepository.deleteById(id);
            return "Deletado com sucesso";
        }catch (Exception e){
            return  "Não foi possível deletar. Causa "+ e.getCause();

        }
    }

}