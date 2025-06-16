package sistema.reaproveitamento.alimentos.project.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OngDTO {
    @NotNull
    private String nome;

    @NotNull
    private String email;
}
