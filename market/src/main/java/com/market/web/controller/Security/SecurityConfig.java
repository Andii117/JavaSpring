package com.market.web.controller.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Nombre:SecurityConfig
 * Descripción: Clase encargada de gestionar los servicios de seguridad del usuario
 *
 * */
/*Anotación encargada de que spring gestione la seguridad*/
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * Nombre: configure
     * Descripción: Servicio encargado de la autentificación del usuario
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*función para indicarle a spring que se utilice el usuario y la contraseña en UserDetailServices*/
        auth.userDetailsService(userDetailsService);
    }
}
