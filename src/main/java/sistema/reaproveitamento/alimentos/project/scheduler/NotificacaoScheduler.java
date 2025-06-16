package sistema.reaproveitamento.alimentos.project.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import sistema.reaproveitamento.alimentos.project.mail.Mail;
import sistema.reaproveitamento.alimentos.project.model.Ong;
import sistema.reaproveitamento.alimentos.project.model.Produto;
import sistema.reaproveitamento.alimentos.project.repository.OngRepository;
import sistema.reaproveitamento.alimentos.project.repository.ProdutoRepository;

import java.time.LocalDate;
import java.util.List;

@Component
public class NotificacaoScheduler {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private OngRepository ongRepository;

    @Autowired
    private Mail mail;

    @Scheduled(cron = "0 28 18 * * ?")
    public void notificacaoProdutosProximoDoVencimento(){
        LocalDate hoje = LocalDate.now();

        List<Ong> listEmail = ongRepository.findAllByEmailIsNotNull();
        List<Produto> produtos = produtoRepository.findByDataValidadeBetween(hoje,hoje.plusDays(10));

        StringBuilder listaProdutos = new StringBuilder();

        for(Produto produto: produtos){
            listaProdutos.append("\n\nNome do Produto: ").append(produto.getNome())
                        .append("\nQuantidade: ").append(produto.getQuantidadeEmKilos()).append("Kg")
                        .append("\nVencimento: ").append(produto.getDataValidade())
                        .append("\n");
        }

        for (Ong ong : listEmail){
            String corpEmail = "Olá "+ ong.getNome()+ "! Gostaríamos de informar que temos a lista de produtos abaixo que vencem dentro dos próximos 10 dias:" + listaProdutos.toString();
            mail.enviarEmail("milenamoraistech@gmail.com", ong.getEmail(),"Produto próximo do vencimento",corpEmail);
        }

    }

}
