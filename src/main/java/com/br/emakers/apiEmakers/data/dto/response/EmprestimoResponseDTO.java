package com.br.emakers.apiEmakers.data.dto.response;

import com.br.emakers.apiEmakers.data.entity.Emprestimo;
import com.br.emakers.apiEmakers.data.entity.Livro;
import com.br.emakers.apiEmakers.data.entity.Pessoa;

public record EmprestimoResponseDTO(
        Long idEmprestimo,
        Pessoa pessoa,
        Livro livro
) {
    public EmprestimoResponseDTO(Emprestimo emprestimo){
        this(emprestimo.getIdEmprestimo(),  emprestimo.getPessoa(), emprestimo.getLivro());
    }
}
