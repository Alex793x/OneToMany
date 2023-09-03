package com.example.onetomanyexample.kommune.service;

import com.example.onetomanyexample.kommune.model.Kommune;
import com.example.onetomanyexample.kommune.repository.KommuneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KommuneService {

    protected final KommuneRepository kommuneRepository;

    public KommuneService(KommuneRepository kommuneRepository) {
        this.kommuneRepository = kommuneRepository;
    }

    public void saveCommunes(List<Kommune> communes) {
        kommuneRepository.saveAll(communes);
    }


}
