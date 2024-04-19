package com.github.techmove.infra.seeds;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.github.techmove.infra.repositories.CategoryRepository;
import com.github.techmove.infra.repositories.GuildRepository;
import com.github.techmove.infra.repositories.UserRepository;
import com.github.techmove.models.Category;
import com.github.techmove.models.Guild;
import com.github.techmove.models.User;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DatabaseSeeder implements CommandLineRunner 
{

    private UserRepository userRepository;
    private CategoryRepository categoryRepository;
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
            var retrievedGuild = guildRepository.findById(1L);
            if (retrievedGuild.isPresent()) guild = retrievedGuild.get();
        }

        if (categoryRepository.count() == 0) 
        {         
            List<Category> categories = List.of(
                Category.builder().name("Comer fruta").score(10).build(),
                Category.builder().name("Fazer atividade física").score(20).build()             
            );
            categoryRepository.saveAll(categories);   
        }

        if (userRepository.count() == 0) 
        {
            String password = "123456";

            User user = User.builder()
            .name("João Paulo Medeiros")
            .email("joao@email.com")
            .password(new BCryptPasswordEncoder().encode(password))
            .score(0)
            .guild(guild)
            .build();
 
            userRepository.save(user);
        }
    }
}