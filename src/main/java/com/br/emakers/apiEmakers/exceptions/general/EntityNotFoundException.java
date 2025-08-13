package com.br.emakers.apiEmakers.exceptions.general;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Long id) {
        super("Entidade com o ID " + id + " não encontrada!");
    }
}
