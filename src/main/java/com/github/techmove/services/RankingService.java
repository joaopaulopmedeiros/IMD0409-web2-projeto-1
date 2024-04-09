package com.github.techmove.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.techmove.models.Guild;
import com.github.techmove.models.Ranking;
import com.github.techmove.models.User;

@Service
public class RankingService {

    public Ranking getByCurrentDate() {
        
        LocalDateTime now = LocalDateTime.now();
        
        var guild = Guild.builder().id(1L).name("Super Guild").build();
        var user = User.builder().name("João Paulo Medeiros").email("joao@email.com").score(97.5).build();
        List<User> users = List.of(user);

        return Ranking.builder()
            .month(now.getMonthValue())
            .year(now.getYear())
            .guild(guild)
            .users(users)
            .build();
    }
    
}
