package sistema.reaproveitamento.alimentos.project.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {

    @NotNull
    private String nome;
    @NotNull
    private LocalDate dataValidade;
    @NotNull
    private String quantidadeEmKilos;
    @NotNull
    private Boolean reaproveitavel;
}
