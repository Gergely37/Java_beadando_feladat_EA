package com.example.szeleromu.repository;

import com.example.szeleromu.model.Helyszin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelyszinRepository extends JpaRepository<Helyszin,Integer> {
}
