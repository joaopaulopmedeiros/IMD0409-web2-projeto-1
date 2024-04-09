package com.github.techmove.infra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.techmove.models.User;

public interface UserRepository extends JpaRepository<User, Long> 
{
    User findByEmail(String email);
}
