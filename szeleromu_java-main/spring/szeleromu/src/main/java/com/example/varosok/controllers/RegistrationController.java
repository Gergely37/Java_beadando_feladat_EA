package com.example.varosok.controllers;

import com.example.varosok.model.Webuser;
import com.example.varosok.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/regisztracio")
    public String getRegistration(WebRequest request, Model model){
        Webuser user = new Webuser();
        model.addAttribute("user",user);
        return "regisztracio";
    }

    @PostMapping("/regisztracio")
    public String postNewUser(@ModelAttribute("user") Webuser user, HttpServletRequest request){
        try{
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            System.out.println(user);
            userRepository.save(user);
            return "bejelentkezes";
        } catch (Error er) {
            System.out.println("HIBA!");
            return "index";
        }
    }
}
