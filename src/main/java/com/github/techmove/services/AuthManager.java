package com.github.techmove.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class AuthManager implements AuthenticationManager {

    private final AuthService authService;

    @Autowired
    public AuthManager(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();
        
        if (authService.signIn(email, password)) {
            return new UsernamePasswordAuthenticationToken(email, password);
        } else {
            throw new AuthenticationException("Authentication failed for user: " + email) {};
        }
    }
}