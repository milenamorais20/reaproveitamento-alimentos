package sistema.reaproveitamento.alimentos.project.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import sistema.reaproveitamento.alimentos.project.mail.Mail;
import sistema.reaproveitamento.alimentos.project.model.Usuario;
import sistema.reaproveitamento.alimentos.project.model.Produto;
import sistema.reaproveitamento.alimentos.project.repository.UsuarioRepository;
import sistema.reaproveitamento.alimentos.project.repository.ProdutoRepository;

import java.time.LocalDate;
import java.util.List;

@Component
public class NotificacaoScheduler {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private Mail mail;

    @Scheduled(cron = "0 0 8 * * ?")
    public void notificacaoProdutosProximoDoVencimento(){
        LocalDate hoje = LocalDate.now();

        List<Usuario> listEmail = usuarioRepository.findAllByEmailIsNotNull();
        List<Produto> produtos = produtoRepository.findByDataValidadeBetween(hoje,hoje.plusDays(10));

        StringBuilder listaProdutos = new StringBuilder();

        for(Produto produto: produtos){
            listaProdutos.append("\n\nNome do Produto: ").append(produto.getNome())
                        .append("\nQuantidade: ").append(produto.getQuantidadeEmKilos()).append("Kg")
                        .append("\nVencimento: ").append(produto.getDataValidade())
                        .append("\n");
        }

        for (Usuario usuario : listEmail){
            String corpEmail = "Olá "+ usuario.getNome()+ "! Gostaríamos de informar que temos a lista de produtos abaixo que vencem dentro dos próximos 10 dias:" + listaProdutos.toString();
            mail.enviarEmail("milenamoraistech@gmail.com", usuario.getEmail(),"Produto próximo do vencimento",corpEmail);
        }

    }

}
