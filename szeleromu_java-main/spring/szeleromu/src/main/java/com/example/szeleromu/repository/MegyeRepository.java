package com.example.szeleromu.repository;

import com.example.szeleromu.model.Megye;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MegyeRepository extends JpaRepository<Megye,Integer> {
}
