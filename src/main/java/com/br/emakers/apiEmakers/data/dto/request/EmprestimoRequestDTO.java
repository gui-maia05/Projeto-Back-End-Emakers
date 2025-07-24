package com.br.emakers.apiEmakers.data.dto.request;

import jakarta.validation.constraints.NotNull;

public record EmprestimoRequestDTO(

        @NotNull(message = "O ID do livro é obrigatório.")
        Long idLivro,

        @NotNull(message = "O ID da pessoa é obrigatório.")
        Long idPessoa
) {
}
