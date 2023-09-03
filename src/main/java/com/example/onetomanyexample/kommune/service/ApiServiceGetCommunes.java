package com.example.onetomanyexample.kommune.service;

import com.example.onetomanyexample.kommune.model.Kommune;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ApiServiceGetCommunes  {

    List<Kommune> getCommunes();
}
