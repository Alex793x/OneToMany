package com.example.onetomanyexample.region.service;

import com.example.onetomanyexample.kommune.model.Kommune;
import com.example.onetomanyexample.region.model.Region;

import java.util.List;

public interface ApiServiceGetRegions {
    List<Region> getRegions();
}
