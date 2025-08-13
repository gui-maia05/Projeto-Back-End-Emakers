package com.br.emakers.apiEmakers.data.dto.response;

import com.br.emakers.apiEmakers.data.entity.Livro;

import java.time.LocalDate;

public record LivroResponseDTO(
        Long idLivro,
        String nome,
        String autor,
        LocalDate dataLancamento
) {
    public LivroResponseDTO(Livro livro){
        this(livro.getIdLivro(),  livro.getNome(), livro.getAutor(), livro.getDataLancamento());
    }


}
