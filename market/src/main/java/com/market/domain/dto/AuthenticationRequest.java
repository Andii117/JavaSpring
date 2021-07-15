package com.market.domain.dto;

/**
 * Nombre:AuthenticationRequest
 * Descripción: Clase encargada de obtener el usuario y contraseña
 * */
public class AuthenticationRequest {
    /*Variables*/
    private String username;
    private String password;

    /*Getters and Setter*/
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
