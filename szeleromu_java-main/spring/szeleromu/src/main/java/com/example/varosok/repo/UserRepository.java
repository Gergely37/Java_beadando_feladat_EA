package com.example.varosok.repo;

import com.example.varosok.model.Webuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Webuser, Integer> {
    Webuser findByUsername(String username);
}
