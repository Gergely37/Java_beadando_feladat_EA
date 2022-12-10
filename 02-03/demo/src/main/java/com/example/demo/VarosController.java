package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController

public class VarosController {
    private final VarosRepository repo;
    private Varos adatVaros;

    VarosController(VarosRepository repo) {	// Dependency Injection
        this.repo = repo;
    }
    Iterable<Varos> olvasMind() {
        return repo.findAll();
    }

    @GetMapping("/varosok/{id}")
    Varos olvasEgy(@PathVariable Long id) {
        return (Varos) repo.findById(id)
                .orElseThrow(() -> new VarosNotFoundException(id));
    }
    @PostMapping("/varosok")
    Varos szemelyFeltolt(@RequestBody Varos ujVaros) {
        return repo.save(ujVaros);
    }
    @PutMapping("/varosok/{id}")
    Varos varosModosit(@RequestBody Varos adatSzemely, @PathVariable Long id) {
        return repo.findById(id)
                .map(a -> {
                    a.setId(adatVaros.getId());
                    a.setNev(adatVaros.getNev());
                    a.setKor(adatVaros.getMegyeid());
                    a.setSuly(adatVaros.getme());
                    return repo.save(a);
                })
                .orElseGet(() -> {
                    adatVaros.setId(id);
                    return repo.save(adatVaros);
                });
    }
    @DeleteMapping("/szemelyek/{id}")
    void torolSzemely(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
