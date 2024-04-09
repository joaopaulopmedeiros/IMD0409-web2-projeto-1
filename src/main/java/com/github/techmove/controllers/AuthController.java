package com.github.techmove.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuthController {
    private AuthenticationManager authenticationManager;

    @GetMapping("/signin")
    public String show() {
        return "auth/signin";
    }    

    @PostMapping("/authenticate")
    public String signin(@RequestParam String email, @RequestParam String password) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(email, password)
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "redirect:/dashboard";
    }

    @PostMapping("/signout")
    public String signout() {
        SecurityContextHolder.clearContext();
        return "redirect:/";
    }  
}
