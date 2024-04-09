package com.github.techmove.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.techmove.infra.repositories.ActivityRepository;
import com.github.techmove.infra.repositories.CategoryRepository;
import com.github.techmove.infra.repositories.UserRepository;
import com.github.techmove.models.Activity;
import com.github.techmove.models.Category;
import com.github.techmove.models.User;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ActivityService 
{
    private ActivityRepository activityRepository;
    private UserRepository userRepository;
    private CategoryRepository categoryRepository;


    public void publish(Long userId, Long categoryId) 
    {
        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) 
        {
            throw new IllegalArgumentException("Usuário não encontrado com o ID: " + userId);
        }

        Optional<Category> category = categoryRepository.findById(categoryId);

        if (category.isEmpty()) 
        {
            throw new IllegalArgumentException("Categoria não encontrada com o ID: " + categoryId);
        }

        var activity = Activity.builder()
        .user(user.get())
        .category(category.get())
        .publishedAt(LocalDateTime.now())
        .build();

        activityRepository.save(activity);
    }    

}
