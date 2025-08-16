package com.br.emakers.apiEmakers.data.entity;

public enum UsuarioRole {

    ADMIN("ADMIN"),

    USER("USER");

    private String role;

    UsuarioRole(String role) {
        this.role = role;
    }
    public String getRole() {
        return role;
    }
}
