package sistema.reaproveitamento.alimentos.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_item_retirada")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemRetirada {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    private Double quantidadeRetirada;
}
