package com.example.onetomanyexample.region.repository;

import com.example.onetomanyexample.kommune.model.Kommune;
import com.example.onetomanyexample.region.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {
    Region findByCode(int code);
    Region findByName(String name);
}
