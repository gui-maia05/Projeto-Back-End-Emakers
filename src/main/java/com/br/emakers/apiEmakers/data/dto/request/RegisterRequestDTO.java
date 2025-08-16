package com.br.emakers.apiEmakers.data.dto.request;

import com.br.emakers.apiEmakers.data.entity.UsuarioRole;
import jakarta.validation.constraints.NotBlank;

public record RegisterRequestDTO(

        @NotBlank(message = "O login é obrigatório.")
        String login,

        @NotBlank(message = "A senha é obrigatória.")
        String password,

        @NotBlank(message = "O role é obrigatório.")
        UsuarioRole role
) {
}
