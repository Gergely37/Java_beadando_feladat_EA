package com.example.szeleromu.api;

import com.example.szeleromu.model.Helyszin;
import com.example.szeleromu.repository.HelyszinRepository;
import com.example.szeleromu.repository.MegyeRepository;
import com.example.szeleromu.repository.ToronyRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.StringWriter;

@RestController
@RequestMapping("/api")
public class SzeleromuAPI {
    @Autowired
    private ToronyRepository toronyRepository;

    @Autowired
    private HelyszinRepository helyszinRepository;

    @Autowired
    private MegyeRepository megyeRepository;

    @GetMapping(value = "/torony", produces = "application/json")
    @ResponseBody
    public String getAllTorony() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        StringWriter sw =new StringWriter();
        mapper.writeValue(sw, toronyRepository.findAll());
        return sw.toString();
    }

    @GetMapping(value = "/torony/{id}", produces = "application/json")
    @ResponseBody
    public String getToronyById(@PathVariable(value = "id") int id) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Jdk8Module());
        String json = mapper.writeValueAsString(toronyRepository.findById(id));
        return json;
    }

    @GetMapping(value = "/helyszin", produces = "application/json")
    @ResponseBody
    public String getAllHelyszin() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        StringWriter sw =new StringWriter();
        mapper.writeValue(sw, helyszinRepository.findAll());
        return sw.toString();
    }

    @GetMapping(value = "/helyszin/{id}", produces = "application/json")
    @ResponseBody
    public String getHelyszinById(@PathVariable(value = "id") int id) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Jdk8Module());
        String json = mapper.writeValueAsString(helyszinRepository.findById(id));
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
