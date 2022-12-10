package com.example.varosok.repo;

import com.example.varosok.model.Varos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VarosRepository extends JpaRepository<Varos, Integer> {
}
