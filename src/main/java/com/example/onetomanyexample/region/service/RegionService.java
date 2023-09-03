package com.example.onetomanyexample.region.service;

import com.example.onetomanyexample.kommune.model.Kommune;
import com.example.onetomanyexample.region.model.Region;
import com.example.onetomanyexample.region.repository.RegionRepository;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RegionService {

    protected final RegionRepository regionRepository;

    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public void saveRegions(List<Region> regions) {
        regionRepository.saveAll(regions);
    }

    public ResponseEntity<?> deleteRegion(int id) {
        if (regionRepository.existsById(id)) {
            regionRepository.deleteById(id);
            return ResponseEntity.ok().body("Region successfully deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Set<Kommune>> getCommunesByRegion(String regionName) {
        Region region = regionRepository.findByName(regionName);
        if (region != null) {
            return ResponseEntity.ok().body(region.getCommunes());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
