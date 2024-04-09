package com.github.techmove.infra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.github.techmove.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM users u WHERE u.email = :email")
    User findByEmail(@Param("email") String email);
}
