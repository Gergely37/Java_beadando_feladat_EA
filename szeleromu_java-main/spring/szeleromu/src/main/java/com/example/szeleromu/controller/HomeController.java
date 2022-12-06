package com.example.szeleromu.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){
        //Ezzel szedel ki infót
        System.out.println("Belépve:\n" + SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0]);
        model.addAttribute("currentUsername",SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("currentUserRole",SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0].toString());
        return "home";
    }

    @GetMapping("/admin")
    public String admin(){
        return "This is admin";
    }

    @GetMapping("/user")
    public String user(){
        return "dashboard";
    }
}
