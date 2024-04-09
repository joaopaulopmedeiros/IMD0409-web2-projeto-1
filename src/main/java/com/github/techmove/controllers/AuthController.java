package com.github.techmove.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.techmove.services.AuthService;

@Controller
public class AuthController 
{
    private AuthService authService;

    @GetMapping("/signin")
    public String show()
    {
        return "auth/signin";
    }    

    @PostMapping("/signin")
    public String signin(@RequestParam String email, @RequestParam String password) 
    {        
        return authService.signIn(email, password) 
            ? "redirect:/dashboard" 
            : "auth/signin"; 
    }   

    @PostMapping("/signout")
    public String signout() 
    {        
        return "redirect:/"; 
    }       
}
