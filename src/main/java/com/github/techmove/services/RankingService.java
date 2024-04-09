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
        
        var guild = new Guild();
        guild.setId(1L);
        guild.setName("Super Guild");

        var user = User.builder().build();
        user.setName("João Paulo Medeiros");
        user.setEmail("joao@email.com");
        user.setScore(97.5);
        List<User> users = List.of(user);

        return Ranking.builder()
            .month(now.getMonthValue())
            .year(now.getYear())
            .guild(guild)
            .users(users)
            .build();
    }
    
}
