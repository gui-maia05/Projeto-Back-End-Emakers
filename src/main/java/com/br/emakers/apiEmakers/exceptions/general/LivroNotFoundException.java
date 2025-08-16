package com.br.emakers.apiEmakers.exceptions.general;

public class LivroNotFoundException extends RuntimeException {
    public LivroNotFoundException(Long id) {
        super("Livro com o ID: " + id + " não encontrado!");
    }
}
