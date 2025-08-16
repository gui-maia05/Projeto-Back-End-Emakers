package com.br.emakers.apiEmakers.data.dto.response;

import com.br.emakers.apiEmakers.data.entity.Pessoa;

public record PessoaResponseDTO(
        Long idPessoa,
        String nome,
        String cpf,
        String cep,
        String email,
        String senha,
        String logradouro,
        String complemento,
        String bairro,
        String localidade,
        String uf
) {
    public PessoaResponseDTO(Pessoa pessoa){
        this(
                pessoa.getIdPessoa(),
                pessoa.getNome(),
                pessoa.getCpf(),
                pessoa.getCep(),
                pessoa.getEmail(),
                pessoa.getSenha(),
                pessoa.getLogradouro(),
                pessoa.getComplemento(),
                pessoa.getBairro(),
                pessoa.getLocalidade(),
                pessoa.getUf()
        );
    }
}
