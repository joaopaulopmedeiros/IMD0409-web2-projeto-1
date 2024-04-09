package com.github.techmove.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.techmove.infra.repositories.CategoryRepository;
import com.github.techmove.models.Category;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CategoryService {

    private CategoryRepository repository; 

    public List<Category> getAll() 
    {
        return repository.findAll();
    }
    
}
