package com.github.techmove.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController 
{
    @GetMapping("/")
    public String show()
    {
        return "index";
    }         
}
