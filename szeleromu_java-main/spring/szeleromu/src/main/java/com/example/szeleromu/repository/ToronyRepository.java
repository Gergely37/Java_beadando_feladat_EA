package com.example.szeleromu.repository;

import com.example.szeleromu.model.Torony;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToronyRepository extends JpaRepository<Torony,Integer> {
}
