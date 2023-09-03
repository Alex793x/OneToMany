package com.example.onetomanyexample.kommune.service;

import com.example.onetomanyexample.kommune.model.Kommune;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ApiServiceGetCommunesImpl implements ApiServiceGetCommunes {

    // Url for API data
    String communesUrl = "https://api.dataforsyningen.dk/kommuner";

    // Field inject Service and RestTemplate
    private final KommuneService kommuneService;
    private final RestTemplate restTemplate;


    // Constructor ---------------------------------------------------
    public ApiServiceGetCommunesImpl(KommuneService kommuneService, RestTemplate restTemplate) {
        this.kommuneService = kommuneService;
        this.restTemplate = restTemplate;
    }


    // Methods ---------------------------------------------------------
    public void saveCommunes(List<Kommune> communes) {
        kommuneService.saveCommunes(communes);
    }

    @Override
    public List<Kommune> getCommunes() {
        ResponseEntity<List<Kommune>> communeResponse = restTemplate.exchange(
                communesUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Kommune>>() {}
        );


        List<Kommune> communes = Optional.ofNullable(communeResponse.getBody()).orElse(Collections.emptyList());
        saveCommunes(communes);
        return communes;
    }
}
