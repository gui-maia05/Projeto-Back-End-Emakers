package com.br.emakers.apiEmakers.exceptions.general;

public class EmprestimoNotFoundException extends RuntimeException {
  public EmprestimoNotFoundException(Long id) {
    super("Empréstimo com o ID: " + id + " não encontrado!");
  }
}
