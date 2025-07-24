package com.br.emakers.apiEmakers.data.entity;

import com.br.emakers.apiEmakers.data.dto.request.PessoaRequestDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table (name = "pessoas")

public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPessoa;

    @Column(name = "nome", nullable = false,  length = 100)
    private String nome;

    @Column(name = "cpf", nullable = false,  length = 11, unique = true)
    private String cpf;

    @Column(name = "cep", nullable = false,  length = 9)
    private String cep;

    @Column(name = "email", nullable = false,  length = 100)
    private String email;

    @Column(name = "senha", nullable = false,  length = 100)
    private String senha;

    @Builder
    public Pessoa(PessoaRequestDTO pessoaRequestDTO) {
        this.nome = pessoaRequestDTO.nome();
        this.cpf = pessoaRequestDTO.cpf();
        this.cep = pessoaRequestDTO.cep();
        this.email = pessoaRequestDTO.email();
        this.senha = pessoaRequestDTO.senha();
    }
}
