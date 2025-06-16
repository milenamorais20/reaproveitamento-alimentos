package sistema.reaproveitamento.alimentos.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotEmpty(message = "Preencha o campo corretamente")
    @Size(min = 3, max =20, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    @Column(name = "name")
    private String nome;

    @NotNull
    @Column(name = "data_validade")
    private LocalDate dataValidade;

    @NotNull
    @Column(name = "quantidade")
    private String quantidadeEmKilos;

    @NotNull
    @Column(name = "reaproveitavel")
    private boolean reaproveitavel;
}
