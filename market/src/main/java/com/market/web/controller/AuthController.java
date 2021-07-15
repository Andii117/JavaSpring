package com.market.web.controller;

import com.market.domain.dto.AuthenticationRequest;
import com.market.domain.dto.AuthenticationResponse;
import com.market.domain.service.UsersDetailsServices;
import com.market.web.Security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Nombre:AuthController
 * Descripción: Clase Controller de spring encargada de las autentificaciones de la aplicación.
 *
 * */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsersDetailsServices usersDetailsServices;
    @Autowired
    private JWTUtil jwtUtil;

    /***
     * Nombre: createToken
     * Descripción:Recibe la petición de crear token
     *
     * Parámetros:
     *      Entrada:authenticationRequest - Solicitud de creación del token
     *      Salida: ResponseEntity<AuthenticationResponse> - Token creado
     */
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest request){

        try{
            /*Servicio encargado de autenticar*/
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(),
                    request.getPassword())
            );/*se carga el usuario que se autentico anteriormente*/
            UserDetails userDetails = usersDetailsServices.loadUserByUsername(request.getUsername());
            /*Generar el token*/
            String jwt = jwtUtil.generateToken(userDetails);
            /*Se retorna una respuesta HTTP :200 (OK) con el Token */
            return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
        }
        catch (BadCredentialsException e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

    }
}
