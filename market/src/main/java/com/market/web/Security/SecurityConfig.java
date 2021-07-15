package com.market.web.Security;

import com.market.web.Security.filter.JwtFileterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

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

    @Autowired
    private JwtFileterRequest jwtFileterRequest;

    /**
     * Nombre: configure
     * Descripción: Servicio encargado de la autentificación del usuario
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*función para indicarle a spring que se utilice el usuario y la contraseña en UserDetailServices*/
        auth.userDetailsService(userDetailsService);
    }

    /**
     * Nombre:configure
     * Descrpción:Servicio usado para que las peticiones al AuthController en /authenticate no necesiten autentificación.
     * Parámetros:
     *      Entrada: http - Solicitud HTTP
     *      Salida:
     *
     * */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*Servicio encargado de que todas las peticiones que terminen en /authenticate las permita*/
        /*Las que no cumplan con esa dirección si deberan tener token de autorización*/
        http.csrf().disable().authorizeRequests().antMatchers("/**/authenticate").permitAll()
                .anyRequest().authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        /*Filtrando las peticiones HTTP*/
        http.addFilterBefore(jwtFileterRequest, UsernamePasswordAuthenticationFilter.class);
    }

    /**
     * Nombre:authenticationManagerBean
     * Descripción: Servicio encargado de autenticar el ManagerBean
    */
    @Override
    /*GEstor de autenticación de la aplicación*/
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
