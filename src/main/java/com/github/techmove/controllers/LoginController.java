package com.github.techmove.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController 
{
    @GetMapping("/login")
    public String show()
    {
        return "login";
    }    

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {        
        return "redirect:/dashboard"; 
    }   

    @PostMapping("/logout")
    public String logout() {        
        return "redirect:/"; 
    }       
}
