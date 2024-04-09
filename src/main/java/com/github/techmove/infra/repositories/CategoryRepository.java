package com.github.techmove.infra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.techmove.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
