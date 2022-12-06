package com.example.szeleromu.controller;

import com.example.szeleromu.model.Contact;
import com.example.szeleromu.model.Torony;
import com.example.szeleromu.repository.ToronyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PowerplanHandlerController {
    @Autowired
    private ToronyRepository toronyRepository;

    @GetMapping("/powerplant_handel")
    public String getPowerplantHandler(Model model){
        model.addAttribute("currentUsername", SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("currentUserRole",SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0].toString());

        model.addAttribute("allData",toronyRepository.findAll());
        return "powerplantedit";
    }

    @GetMapping("/powerplant_handel/edit")
    public String editPowerplant(@RequestParam(name = "id") int id, Model model){
        model.addAttribute("currentUsername", SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("currentUserRole",SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0].toString());

        model.addAttribute("data",toronyRepository.findById(id));

        return "powerplant_edit";
    }

    @PostMapping("/powerplant_handel/edit")
    public String finalEditPowerplant(@ModelAttribute("data") Torony torony, Model model){
        model.addAttribute("currentUsername", SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("currentUserRole",SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0].toString());
        toronyRepository.save(torony);

        return "redirect:/powerplant_handel";
    }

    @GetMapping("/powerplant_handel/delete")
    public String finalEditPowerplant(@RequestParam(name = "id") int id){
        toronyRepository.deleteById(id);

        return "redirect:/powerplant_handel";
    }
}
