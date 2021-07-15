package com.market.domain.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

    /**
     * Nombre: UsersDetailsServices
     * Descripción: Interface encargada de los servicios de Usuario
     * Nota: el extends deberia ser un implements pero genera error y la solución que da es usar el extends
     * */
    @Service
    public class UsersDetailsServices implements UserDetailsService {
        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            return new User("andres", "{noop}1234", new ArrayList<>());
        }
    }

