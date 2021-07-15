package com.market.web.Security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Nombre:JWTUtil (JWT JSON Web Token)
 * Descripción: Clase encargada de manejar las sesiones del usuario por medio de Tokens
 * */
@Component
public class JWTUtil {
    /*Llave encargada de cifrar la información*/
    private static final String KEY = "Alfa";

    /**
     * Nombre:generateToken
     * Descripción: Generador del Token cifrado
     *
     * Parámetros:
     *      Entrada: userDetails - UserDetails que provee JWT para Spring
     *      Salida   Jwts - Token encriptado
     * */
    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername()) /*setSubject establece el usuario*/
                .setIssuedAt(new Date())/*setIssuedAt establece la fecha de inicio*/
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))/*setExpiration establece la cantidad de tiempo a expirar*/
                .signWith(SignatureAlgorithm.HS256, KEY).compact();/*signWith Establece el tipo de algoritmo a usar(HS256) y la llave de encriptamiento KEY*/
    }

    /**
     * Nombre: getClaims
     * Descripción: Obtiene los Claims(Objetos) de Jwt parseando la llave
     *              y devolviendo el cuerpo del JWT
     * Parámetros:
     *      Entrada: token - Id token
     *      Salida Jwts - Objeto JWT
     * */
    private Claims getClaims(String token){
        return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
    }

    /**
     * Nombre: extractUsername
     * Descripción: Servicio que se encarga de extraer el Username del token
     * Parámetros:
     *      Entrada: token - Token
     *      Salida: Username - nombre de usuario.
     * */
    public String extractUsername(String token){
        return getClaims(token).getSubject();

    }

    /**
     * Nombre: isTokenExpired
     * Descripción: Servicio que se encarga de validar si el token expiro
     * Parámetros:
     *      Entrada: token - Token
     *      Salida: True - El token ha expirado
     *              False - El token no ha expirado
     * */
    public boolean isTokenExpired(String token){
        /*Obtenemos el objeto del token la sección de Expiración y lo comparamos contra la fecha actual
        * Si la fecha de expiración esta antes de la fecha actual retorna true
        * si esta depues de la fecha actual significa que todavia está activo*/
         return getClaims(token).getExpiration().before(new Date());
    }


    /**
     * Nombre: validateToken
     * Descripción: Devuelve un true si cumple que el usuario que esta iniciando sesión es el mismo del token
     *              y si el token sigue vigente de lo contrario devuelve false
     * Parámetros:
     *      Entrada: token - Token
     *               UserDetails - Usuario que se encuentra conectado
     *      Salida: True - El usuario puede acceder a las urls el token esta vigente
     *              False - El usaurio no puede acceder a las urls el token no esta vigente
     * */
    public boolean validateToken(String token,UserDetails userDetails){
        /*Devuelve un true si cumple que el usuario que esta iniciando sesión es el mismo del token
        * y si el token sigue vigente de lo contrario devuelve false*/
        return userDetails.getUsername().equals(extractUsername(token)) && !isTokenExpired(token);
    }
}