package com.market.domain.dto;

/**
 * Nombre:AuthenticationResponse
 * Descripción: Clase encargada de los servicios de respuesta de autenticación con el token
 * */
public class AuthenticationResponse {
    /*Variables*/
    private String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    /*Getters and Setter*/
    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
