package com.rodrigo.user_management_api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

public class UserRequestDTO {

    @Getter
    @Setter
    @NotBlank(message = "Nome é obrigatório")
    private String name;

    @Getter
    @Setter
    @Email(message = "Email inválido")
    private String email;

    @Getter
    @Setter
    @Size(min = 6, message = "Senha deve ter pelo menos 6 caracteres")
    private String password;
}
