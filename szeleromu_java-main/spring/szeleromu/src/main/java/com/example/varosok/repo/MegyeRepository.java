package com.example.varosok.repo;

import com.example.varosok.model.Megye;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MegyeRepository extends JpaRepository<Megye,Integer> {
}
