package com.example.szeleromu.controller;

import com.example.szeleromu.model.Webuser;
import com.example.szeleromu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @GetMapping("/registration")
    public String getRegistration(WebRequest request, Model model){
        Webuser user = new Webuser();
        model.addAttribute("user",user);
        return "registration";
    }

    @PostMapping("/registration")
    public String postNewUser(@ModelAttribute("user") Webuser user, HttpServletRequest request){
        try{
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            System.out.println(user);
            userRepository.save(user);
            return "login";
        } catch (Error er) {
            System.out.println("BAJ!");
            return "home";
        }
    }
}
