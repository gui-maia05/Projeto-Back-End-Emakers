package com.br.emakers.apiEmakers.exceptions.general;

public class PessoaNotFoundException extends RuntimeException {
    public PessoaNotFoundException(Long id) {
        super("Pessoa com o ID: " + id + " não encontrada!");
    }
}
