package com.example.szeleromu.controller;

import com.example.szeleromu.model.Contact;
import com.example.szeleromu.repository.ContactRepository;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.stream.Collectors;


@Controller
public class ContactController {
    @Autowired
    private ContactRepository contactRepository;

    @GetMapping("/contact")
    public String getContact(Model model){
        Contact contact = new Contact();

        //model.addAttribute("username", SecurityContextHolder.getContext().getAuthentication().getName());
        //model.addAttribute("role",SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0].toString());
        model.addAttribute("contact",contact);

        return "contact";
    }

    @PostMapping("/contact")
    public String postConact(@Validated @ModelAttribute("contact") Contact contact, BindingResult result, Model model){
        //Adat mentése
        try{
            System.out.println(contact);
            model.addAttribute("currentUsername",SecurityContextHolder.getContext().getAuthentication().getName());
            model.addAttribute("currentUserRole",SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0].toString());
            //TODO 3. Ha valami rossz
            if (result.hasErrors()){
                String errorMessage = result
                        .getFieldErrors()
                        .stream()
                        .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                        .collect(Collectors.joining("; "));
                model.addAttribute("Hiba",errorMessage);
                return("/contact");
            }

            //Küldés dátum
            Date now = new Date(System.currentTimeMillis());
            contact.setSendDate(now);

            //Felhasználói adatok
            if (SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0].toString().equals("USER")) {
                contact.setRole("Felhasználó");
            }
            if (SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0].toString().equals("ROLE_ANONYMOUS")) {
                contact.setRole("Vendég");
            }
            contact.setSender(SecurityContextHolder.getContext().getAuthentication().getName());
            contactRepository.save(contact);
            //TODO 1. Egy siker oldal kell
            return "home";
        }
        catch (Error er) {
            //TODO 2. Egy hiba oldal kell
            System.out.println("HIBA!" + er.getMessage());
            return "error";
        }
    }
}
