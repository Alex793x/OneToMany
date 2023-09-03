package com.example.onetomanyexample.region.service;

import com.example.onetomanyexample.region.model.Region;
import com.example.onetomanyexample.region.repository.RegionRepository;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ApiServiceGetRegionsImpl implements ApiServiceGetRegions{

    // Url where we pick up the region data
    String regionUrl = "https://api.dataforsyningen.dk/regioner";

    // Region Repository Field Injection
    private final RegionService regionService;

    // RestTemplate Field Injection
    protected final RestTemplate restTemplate;


    // Constructor ------------------------------------------
    public ApiServiceGetRegionsImpl(RegionService regionService, RegionRepository regionRepository, RegionService regionService1, RestTemplate restTemplate) {
        this.regionService = regionService1;
        this.restTemplate = restTemplate;
    }


    // Methods -----------------------------------------------

    public void saveRegions(List<Region> regions) {
        regionService.saveRegions(regions);
    }


    @Override
    public List<Region> getRegions() {
        ResponseEntity<List<Region>> regionResponse = restTemplate.exchange(
                regionUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Region>>() {}
        );

        List<Region> regions = Optional.ofNullable(regionResponse.getBody()).orElse(Collections.emptyList());
        saveRegions(regions);
        return regions;
    }


}
