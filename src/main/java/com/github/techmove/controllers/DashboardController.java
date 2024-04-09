package com.github.techmove.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.github.techmove.services.CategoryService;
import com.github.techmove.services.RankingService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DashboardController 
{
    private RankingService rankingService;
    private CategoryService categoryService;

    @GetMapping("/dashboard")
    public String show(Model model)
    {
        var ranking = rankingService.getByCurrentDate();
        model.addAttribute("ranking", ranking);
        return "dashboard/index";
    }    
    
    @GetMapping("/dashboard/activity-form")
    public String showActivityForm(Model model)
    {
        var categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        return "dashboard/activity-form";
    }    
}
