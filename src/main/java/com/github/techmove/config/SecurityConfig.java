package com.github.techmove.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;

import com.github.techmove.services.AuthManager;

@Configuration
public class SecurityConfig {

    @Autowired
    private AuthManager authManager;

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return authManager;
    }
}
