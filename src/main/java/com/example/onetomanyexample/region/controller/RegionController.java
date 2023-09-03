package com.example.onetomanyexample.region.controller;

import com.example.onetomanyexample.region.service.RegionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RegionController {

    // Field injecting service layers
    private final RegionService regionService;

    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @DeleteMapping("/region/{id}")
    public ResponseEntity<?> deleteRegion(@PathVariable int id) {
        return regionService.deleteRegion(id);
    }
}
