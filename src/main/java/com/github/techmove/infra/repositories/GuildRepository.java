package com.github.techmove.infra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.techmove.models.Guild;

public interface GuildRepository extends JpaRepository<Guild, Long> {
}
