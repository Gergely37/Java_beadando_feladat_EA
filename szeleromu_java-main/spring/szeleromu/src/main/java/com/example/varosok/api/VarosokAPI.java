package com.example.varosok.api;


import com.example.varosok.repo.LelekszamRepository;
import com.example.varosok.repo.MegyeRepository;
import com.example.varosok.repo.VarosRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.StringWriter;

@RestController
@RequestMapping("/api")
public class VarosokAPI {
    @Autowired
    private VarosRepository varosRepository;

    @Autowired
    private LelekszamRepository lelekszamRepository;

    @Autowired
    private MegyeRepository megyeRepository;

    @GetMapping(value = "/varos", produces = "application/json")
    @ResponseBody
    public String getAllVaros() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        StringWriter sw =new StringWriter();
        mapper.writeValue(sw, varosRepository.findAll());
        return sw.toString();
    }

    @GetMapping(value = "/varos/{id}", produces = "application/json")
    @ResponseBody
    public String getVarosById(@PathVariable(value = "id") int id) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Jdk8Module());
        String json = mapper.writeValueAsString(varosRepository.findById(id));
        return json;
    }

    @GetMapping(value = "/lelekszam", produces = "application/json")
    @ResponseBody
    public String getAllLelekszam() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        StringWriter sw =new StringWriter();
        mapper.writeValue(sw, lelekszamRepository.findAll());
        return sw.toString();
    }

    @GetMapping(value = "/lelekszam/{id}", produces = "application/json")
    @ResponseBody
    public String getLelekszamById(@PathVariable(value = "id") int id) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Jdk8Module());
        String json = mapper.writeValueAsString(lelekszamRepository.findById(id));
        return json;
    }

    @GetMapping(value = "/megye", produces = "application/json")
    @ResponseBody
    public String getAllMegye() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        StringWriter sw =new StringWriter();
        mapper.writeValue(sw, megyeRepository.findAll());
        return sw.toString();
    }

    @GetMapping(value = "/megye/{id}", produces = "application/json")
    @ResponseBody
    public String getMegyeById(@PathVariable(value = "id") int id) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Jdk8Module());
        String json = mapper.writeValueAsString(megyeRepository.findById(id));
        return json;
    }


}
