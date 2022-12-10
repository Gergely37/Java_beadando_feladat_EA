package com.example.demo;

import com.example.demo.Varos;

import java.util.Optional;

public interface VarosRepository extends CrudRepository<Varos, Long> {

    Iterable<Varos> findAll();

    Optional<Object> findById(Long id);

    Varos save(Varos ujVaros);

    void deleteById(Long id);

    void save(Varos izsák);
}
