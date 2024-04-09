package com.github.techmove.infra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.techmove.models.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> 
{
}