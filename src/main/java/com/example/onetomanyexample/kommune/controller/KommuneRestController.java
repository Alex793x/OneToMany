package com.example.onetomanyexample.kommune.controller;

import com.example.onetomanyexample.kommune.model.Kommune;
import com.example.onetomanyexample.kommune.service.ApiServiceGetCommunes;
import com.example.onetomanyexample.kommune.service.KommuneService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KommuneRestController {

    // Field injecting service layers
    private final KommuneService kommuneService;
    private final ApiServiceGetCommunes apiServiceGetCommunes;

    // Constructor ----------------------------------------
    public KommuneRestController(KommuneService kommuneService, ApiServiceGetCommunes apiServiceGetCommunes) {
        this.kommuneService = kommuneService;
        this.apiServiceGetCommunes = apiServiceGetCommunes;
    }

    // Mappings --------------------------------------------
    @GetMapping("/communes")
    public List<Kommune> getCommunes() {
        return apiServiceGetCommunes.getCommunes();
    }
}
