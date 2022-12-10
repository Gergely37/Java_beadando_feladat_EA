package com.example.varosok.controllers;

import com.example.varosok.model.Contact;
import com.example.varosok.repo.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.List;

@Controller
public class ContactViewController {
    @Autowired
    private ContactRepository contactRepository;

    @GetMapping("/contact_view")
    public String getContacts(Model model){
        model.addAttribute("currentUsername", SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("currentUserRole",SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0].toString());

        List<Contact> data = contactRepository.findAll();
        Collections.sort(data);
        model.addAttribute("data", data);

        return "contact_view";
    }
}
