package com.github.techmove.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.techmove.BasicEncoder;
import com.github.techmove.infra.repositories.UserRepository;
import com.github.techmove.models.User;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuthService 
{
    private UserRepository userRepository;

    public boolean signIn(String email, String password) 
    {
        User user = userRepository.findByEmail(email);

        if (user != null) 
        {
            return BasicEncoder.matches(password + user.getSalt(), user.getHash());
        }

        return false;
    }    
}
