package com.example.varosok.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){
        System.out.println("Belépve:\n" + SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0]);
        model.addAttribute("currentUsername",SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("currentUserRole",SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0].toString());
        return "index";
    }

    @GetMapping("/admin")
    public String admin(){
        return "Admin";
    }

    @GetMapping("/user")
    public String user(){
        return "usual";
    }
}
