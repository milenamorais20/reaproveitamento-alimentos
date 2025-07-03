package sistema.reaproveitamento.alimentos.project.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {

    @NotBlank
    @Size(min = 3, max =20, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String nome;

    @NotNull
    @Past(message = "Data '${validatedValue}' é inválida.")
    private LocalDate dataValidade;

    @NotBlank
    private Double quantidadeEmKilos;

    private Boolean reaproveitavel = true;
}
