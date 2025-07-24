package com.br.emakers.apiEmakers.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "livros")

public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLivro;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "autor", nullable = false, length = 100)
    private String autor;

    @Column(name = "dataLancamento", nullable = false)
    private LocalDate dataLancamento;
}
