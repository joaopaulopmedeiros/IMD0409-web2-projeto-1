package com.github.techmove.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.github.techmove.services.RankingService;

@Controller
public class DashboardController 
{
    @Autowired
    private RankingService service;

    @GetMapping("/dashboard")
    public String dashboard(Model model)
    {
        var ranking = service.getByCurrentDate();
        model.addAttribute("ranking", ranking);
        return "dashboard";
    }     
}
