package com.github.techmove.infra.seeds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.techmove.infra.repositories.UserRepository;
import com.github.techmove.models.User;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            User user = User.builder()
            .name("João Paulo Medeiros")
            .email("joao@email.com")
            .salt("salt")
            .hash("hash")
            .score(0)
            .build();
            userRepository.save(user);
        }
    }
}