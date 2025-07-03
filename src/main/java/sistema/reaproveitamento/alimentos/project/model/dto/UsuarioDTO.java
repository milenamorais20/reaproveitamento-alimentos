package sistema.reaproveitamento.alimentos.project.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    @NotBlank
    private String nome;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Formato inválido")
    private String email;
}
