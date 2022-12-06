package com.example.szeleromu.controller;

import com.example.szeleromu.model.Eromu;
import com.example.szeleromu.model.Helyszin;
import com.example.szeleromu.model.Megye;
import com.example.szeleromu.model.Torony;
import com.example.szeleromu.repository.HelyszinRepository;
import com.example.szeleromu.repository.MegyeRepository;
import com.example.szeleromu.repository.ToronyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserTableView {
    @Autowired
    private HelyszinRepository helyszinRepository;

    @Autowired
    private MegyeRepository megyeRepository;

    @Autowired
    private ToronyRepository toronyRepository;

    @GetMapping("/powerplant")
    public String getPowerplants(Model model){
        //Összes adat

        model.addAttribute("allData",toronyRepository.findAll());
        model.addAttribute("currentUsername", SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("currentUserRole",SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0].toString());

        return "usertable";
    }
}
