package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Configuration

public class LoadDatabase {
    private static Logger LoggerFactory;
    private static final Logger log = LoggerFactory.getLogger(String.valueOf(LoadDatabase.class));
    @Bean
    CommandLineRunner initDatabase(src.main.java.com.example.demo.VarosRepository repository) {
        return args -> {
            if(true){  // Első feltöltés után állítsuk false-ra, mert minden futtatáskor újra feltöltené
                repository.save(new Varos(111, "Kecskemet", 10, true,true));
                repository.save(new Varos(112, "Dabas", 11, false,false));
                repository.save(new Varos(112, "Izsák", 11, false,false));
            }
        };
    }
}

