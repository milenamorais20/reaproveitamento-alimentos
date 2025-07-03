package sistema.reaproveitamento.alimentos.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tb_produto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Size(min = 3, max =20, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    @Column(name = "name")
    private String nome;

    @Column(name = "data_validade")
    @Future(message = "A data de validade '${validatedValue}' deve ser no futuro.")
    private LocalDate dataValidade;

    @Column(name = "quantidade")
    private Double quantidadeEmKilos;

    @Column(name = "reaproveitavel")
    private Boolean reaproveitavel = true;
}
