package com.example.onetomanyexample.kommune.repository;

import com.example.onetomanyexample.kommune.model.Kommune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KommuneRepository extends JpaRepository<Kommune, Integer> {
    Kommune findKommuneByCode(int code);

}
