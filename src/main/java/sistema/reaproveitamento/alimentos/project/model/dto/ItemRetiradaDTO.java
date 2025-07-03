package sistema.reaproveitamento.alimentos.project.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemRetiradaDTO {
    @NotNull
    private Integer produtoId;
    @NotNull
    private Double quantidadeRetirada;
}
