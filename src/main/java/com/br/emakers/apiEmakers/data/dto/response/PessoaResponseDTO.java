package com.br.emakers.apiEmakers.data.dto.response;

import com.br.emakers.apiEmakers.data.entity.Pessoa;

public record PessoaResponseDTO(
        Long idPessoa,
        String nome,
        String cpf,
        String cep,
        String email,
        String senha
) {
    public PessoaResponseDTO(Pessoa pessoa){
        this(pessoa.getIdPessoa(), pessoa.getNome(), pessoa.getCpf(), pessoa.getCep(),  pessoa.getEmail(), pessoa.getSenha());
    }
}
