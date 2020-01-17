package com.bscthesis.backend.configuration;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class JwtFilter extends BasicAuthenticationFilter {

    public JwtFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader("Authorization");
        UsernamePasswordAuthenticationToken authenticationToken = getAuthenticationByToken(header);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request,response);
    }

    private UsernamePasswordAuthenticationToken getAuthenticationByToken(String header) {
        DecodedJWT jwt;
        UsernamePasswordAuthenticationToken authenticationToken;
        try {
            jwt = JWT.decode(header.replace("Bearer ",""));
            String principal = jwt.getClaim("email").asString();
            String credentials = jwt.getClaim("password").asString();
            String role = jwt.getClaim("role").asString();
            List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(role));
            authenticationToken = new UsernamePasswordAuthenticationToken(principal,credentials, authorities);
            return authenticationToken;
        } catch (JWTDecodeException exception){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,exception.getLocalizedMessage(),exception);
        }
    }
}
