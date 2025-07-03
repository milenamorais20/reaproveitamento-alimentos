package sistema.reaproveitamento.alimentos.project.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RetiradaDTO {
    @NotNull
    private Integer usuarioId;

    @NotNull
    private Integer produtoId;

    @NotNull
    private Double quantidadeRetirada;
}