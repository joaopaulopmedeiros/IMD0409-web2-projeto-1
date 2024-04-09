package com.github.techmove.infra.seeds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.techmove.infra.repositories.GuildRepository;
import com.github.techmove.infra.repositories.UserRepository;
import com.github.techmove.models.Guild;
import com.github.techmove.models.User;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DatabaseSeeder implements CommandLineRunner 
{

    private UserRepository userRepository;
    private GuildRepository guildRepository;

    @Override
    public void run(String... args) throws Exception {
 
        
        Guild guild = null;

        if (guildRepository.count() == 0) 
        {         
            guild = Guild.builder().name("IMD Guild").build();
            guildRepository.save(guild);   
        } else 
        {
            guild = guildRepository.getReferenceById(0L); 
        }

        if (userRepository.count() == 0) 
        {
            User user = User.builder()
            .name("João Paulo Medeiros")
            .email("joao@email.com")
            .salt("salt")
            .hash("hash")
            .score(0)
            .guild(guild)
            .build();
 
            userRepository.save(user);
        }
    }
}