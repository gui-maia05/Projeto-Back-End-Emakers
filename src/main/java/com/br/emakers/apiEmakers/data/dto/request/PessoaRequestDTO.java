package com.br.emakers.apiEmakers.data.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record PessoaRequestDTO(

        @NotBlank(message = "O nome é obrigatório.")
        String nome,

        @NotBlank(message = "O CPF é obrigatório.")
        @Pattern(regexp = "//d{11}", message = "O CPF deve conter exatamente 11 números.")
        String cpf,

        @NotBlank(message = "O CEP é obrigatório.")
        @Pattern(regexp = "//d{9}", message = "O CEP deve conter exatamente 9 números.")
        String cep,

        @Email(message = "E-mail inválido.")
        @NotBlank(message = "O e-mail é obrigatório.")
        String email,

        @NotBlank(message = "A senha é obrigatória.")
        String senha
) {
}
