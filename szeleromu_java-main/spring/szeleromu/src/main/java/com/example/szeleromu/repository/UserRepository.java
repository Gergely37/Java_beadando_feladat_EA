package com.example.szeleromu.repository;

import com.example.szeleromu.model.Webuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Webuser, Integer> {
    Webuser findByUsername(String username);
}
