package com.github.techmove.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.github.techmove.services.CustomUserDetailsService;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig 
{
    @Bean
    SecurityFilterChain resources(HttpSecurity http) throws Exception 
    {
        return http
                .securityMatcher("/images/**", "/**.css", "/**.js")
                .authorizeHttpRequests(c -> c.anyRequest().permitAll())
                .securityContext(c -> c.disable())
                .sessionManagement(c -> c.disable())
                .requestCache(c -> c.disable())
                .build();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception 
    {
        http.authorizeHttpRequests(authz -> authz
            .requestMatchers("/").permitAll()
        );

        http.authorizeHttpRequests(authz -> authz
            .requestMatchers("/login", "/error").permitAll()
            .anyRequest().authenticated()
        );

        http.formLogin(authz -> authz
            .loginPage("/login").permitAll()
            .defaultSuccessUrl("/dashboard")
        );

        http.logout(authz -> authz
            .logoutSuccessUrl("/")
            .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID")
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        );

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationProvider authenticationProvider(CustomUserDetailsService customUserDetailsService) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(customUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

}
