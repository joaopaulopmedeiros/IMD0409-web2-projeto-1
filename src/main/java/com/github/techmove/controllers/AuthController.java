package com.github.techmove.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController 
{
    @GetMapping("/signin")
    public String show()
    {
        return "auth/signin";
    }    

    @PostMapping("/signin")
    public String signin(@RequestParam String email, @RequestParam String password) {        
        return "redirect:/dashboard"; 
    }   

    @PostMapping("/signout")
    public String signout() {        
        return "redirect:/"; 
    }       
}
