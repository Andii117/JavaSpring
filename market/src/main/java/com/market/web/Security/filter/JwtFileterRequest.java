package com.market.web.Security.filter;

import com.market.domain.service.UsersDetailsServices;
import com.market.web.Security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Nombre: JwtFileterRequest (Filtro de peticiones JWT)
 * Descripción: Filtra todas las peticiones JWT
 * */
@Component
public class JwtFileterRequest extends OncePerRequestFilter {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private UsersDetailsServices usersDetailsServices;


    /**
     * Nombre: doFilterInternal
     * Descripción: Filtra todas las peticiones JWT
     * Parámetros:
     *      Entrada:
     *             request -Petición.
     *             response- Respuesta
     *             filterChain - Filtro
     *      Salida:
     * */
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
                        throws ServletException, IOException {
        /*Obtiene la autorización del Header de la petición*/
        String AuthorizationHeader = request.getHeader("Authorization");

        if( AuthorizationHeader != null && AuthorizationHeader.startsWith("Bearer")){
            /*Obtenemos el jwt sin la sigla Bearer*/
            String jwt = AuthorizationHeader.substring(7);
            /*Obtenemos el username*/
            String username = jwtUtil.extractUsername(jwt);
            /*Validación que se realiza para que en el contexto se valide que no existe autenticación de este usuario*/
            if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
                /*Valida si el usuario que intenta acceder a la petición ya existe en el contexto*/
                UserDetails userDetails = usersDetailsServices.loadUserByUsername(username);
                /*JWT es correcto*/
                if(jwtUtil.validateToken(jwt, userDetails)){
                    /*se crea la autorización con el token pasandole el userDetails y las aturotizaciones genericas*/
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
                            null,userDetails.getAuthorities());
                    /*Se adicionan los detalles de la conexión que esta recibiendo
                    * Horario de entrada
                    * Navegador
                    * SO tiene
                    * */
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    /*Se asigna la autenticación para que no siempre pase la validación*/
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }
        }
        /*Evaluar el filter con doFilter*/
        filterChain.doFilter(request,response);
    }

}
