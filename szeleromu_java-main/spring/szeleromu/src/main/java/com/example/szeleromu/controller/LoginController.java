package com.example.szeleromu.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("currentUsername", SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("currentUserRole",SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0].toString());
        return "login";
    }
}
