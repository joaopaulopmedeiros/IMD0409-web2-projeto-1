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


    public void publish(String email, Long categoryId) 
    {
        User user = userRepository.findByEmail(email);

        if (user == null) 
        {
            throw new IllegalArgumentException("Usuário não encontrado com o email: " + email);
        }

        Optional<Category> category = categoryRepository.findById(categoryId);

        if (category.isEmpty())
        {
            throw new IllegalArgumentException("Categoria não encontrada com o ID: " + categoryId);
        }

        var activity = Activity.builder()
        .user(user)
        .category(category.get())
        .publishedAt(LocalDateTime.now())
        .build();

        activityRepository.save(activity);

        user.setScore(user.getScore() + category.get().getScore());

        userRepository.save(user);
    }    

}
