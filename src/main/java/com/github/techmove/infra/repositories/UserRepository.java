package com.github.techmove.infra.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.github.techmove.models.User;

public interface UserRepository extends JpaRepository<User, Long> 
{
    User findByEmail(String email);

    @Query("SELECT u " +
    "FROM Activity a " +
    "JOIN User u ON a.user.id = u.id " +
    "JOIN Category c ON c.id = a.category.id " +
    "WHERE u.guild.id = :guildId " +
    "GROUP BY u.id, u.name, u.email")
List<User> findByGuild(@Param("guildId") Long guildId);

}
