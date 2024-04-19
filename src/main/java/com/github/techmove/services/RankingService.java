package com.github.techmove.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.github.techmove.infra.repositories.UserRepository;
import com.github.techmove.models.Ranking;

@Service
public class RankingService 
{
    @Autowired
    private UserRepository repository;

    public Ranking getByCurrentDate() 
    {
        LocalDateTime now = LocalDateTime.now();
        var email = SecurityContextHolder.getContext().getAuthentication().getName();
        var guild = repository.findByEmail(email).getGuild();
        var users = repository.findByGuild(guild.getId());

        return Ranking.builder()
            .month(now.getMonthValue())
            .year(now.getYear())
            .guild(guild)
            .users(users)
            .build();
    }   
}
