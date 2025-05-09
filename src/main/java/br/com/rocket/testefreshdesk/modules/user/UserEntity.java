package br.com.rocket.testefreshdesk.modules.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jdk.jfr.Name;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.UUID;

@Data
@EntityScan
public class UserEntity {

    private Long id;

    @NotBlank(message = "Nome obrigatório")
    private String name;

    @NotBlank @Email(message = "E-mail inválido")
    private String email;

    @NotBlank @Size(min = 6, message = "Senha deve ter pelo menos 6 caracteres")
    private String password;
}
