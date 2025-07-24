package com.br.emakers.apiEmakers.data.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record LivroRequestDTO(

        @NotBlank(message = "O nome do livro é obrigatório.")
        String nome,

        @NotBlank(message = "O nome do autor é obrigatório.")
        String autor,

        @JsonFormat(pattern = "dd/MM/yyyy")
        @PastOrPresent(message = "A data de lançamento não pode ser no futuro.")
        LocalDate dataLancamento
) {
}
