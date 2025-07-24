package com.br.emakers.apiEmakers.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name = "emprestimos")

public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmprestimo;

    @ManyToOne()
    @JoinColumn(name = "idLivro")
    private Livro livro;

    @ManyToOne()
    @JoinColumn(name = "idPessoa")
    private Pessoa pessoa;
}
