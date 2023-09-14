package com.example.onetomanyexample.region.controller;

import com.example.onetomanyexample.kommune.model.Kommune;
import com.example.onetomanyexample.region.model.Region;
import com.example.onetomanyexample.region.service.ApiServiceGetRegions;
import com.example.onetomanyexample.region.service.RegionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class RegionRestController {

    // Field injecting service layers
    private final RegionService regionService;
    private final ApiServiceGetRegions apiServiceGetRegions;

    // Constructor ----------------------------------------------------
    public RegionRestController(RegionService regionService, ApiServiceGetRegions apiServiceGetRegions) {
        this.regionService = regionService;
        this.apiServiceGetRegions = apiServiceGetRegions;
    }

    // Mappings ------------------------------------------------------
    @GetMapping("/regions")
    public List<Region> getAllRegions() {
        return apiServiceGetRegions.getRegions();
    }

    @GetMapping("/communesByRegions/{regionName}")
    public ResponseEntity<Set<String>> getCommunesByRegion(@PathVariable String regionName) {
        return regionService.getCommunesByRegion(regionName);
    }
}
