package com.github.techmove.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.github.techmove.infra.repositories.UserRepository;
import com.github.techmove.models.User;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuthService implements UserDetailsService
{
    private UserRepository userRepository;

    public boolean signIn(String email, String password) 
    {
        User user = userRepository.findByEmail(email);

        if (user != null) 
        {
            return new BCryptPasswordEncoder().matches(password + user.getSalt(), user.getHash());
        }

        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
    {
        User user = userRepository.findByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + username);
        }
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getHash())
                .roles("USER")
                .build();
    }    
}
