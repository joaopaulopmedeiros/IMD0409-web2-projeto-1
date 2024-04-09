package com.github.techmove.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.techmove.services.ActivityService;
import com.github.techmove.services.CategoryService;
import com.github.techmove.services.RankingService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DashboardController 
{
    private RankingService rankingService;
    private CategoryService categoryService;
    private ActivityService activityService;

    @GetMapping("/dashboard")
    public String show(Model model)
    {
        var ranking = rankingService.getByCurrentDate();
        model.addAttribute("ranking", ranking);
        model.addAttribute("email", SecurityContextHolder.getContext().getAuthentication().getName());
        return "dashboard/index";
    }    
    
    @GetMapping("/dashboard/activity/form")
    public String showActivityForm(Model model)
    {
        var categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        return "dashboard/activity-form";
    }    

    @PostMapping("/dashboard/activity/publish")
    public String publishActivity(Model model, @RequestParam("userId") Long userId, @RequestParam("categories") Long categoryId)
    {
        activityService.publish(userId, categoryId);
        return "redirect:/dashboard";
    }    
}
