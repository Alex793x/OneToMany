package com.example.onetomanyexample.addresser.service;

import com.example.onetomanyexample.addresser.model.Address;
import com.example.onetomanyexample.addresser.model.AddressDTO;
import com.example.onetomanyexample.addresser.repository.AddressRepository;
import com.example.onetomanyexample.kommune.model.Kommune;
import com.example.onetomanyexample.kommune.repository.KommuneRepository;
import com.example.onetomanyexample.region.model.Region;
import com.example.onetomanyexample.region.repository.RegionRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressMapper {

    // Field injecting Commune / Region Repository
    private final KommuneRepository kommuneRepository;
    private final RegionRepository regionRepository;

    // Constructor ---------------------------------------------------
    public AddressMapper(AddressRepository addressRepository, KommuneRepository kommuneRepository, RegionRepository regionRepository) {
        this.kommuneRepository = kommuneRepository;
        this.regionRepository = regionRepository;
    }

    // Methods -------------------------------------------------------
    public void mapRelationships(Address address) {
        Region region = regionRepository.findByCode(Integer.parseInt(address.getRegionCode()));
        Kommune kommune = kommuneRepository.findKommuneByCode(Integer.parseInt(address.getCommuneCode()));

        if (region != null) {
            address.setRegion(region);
        }

        if (kommune != null) {
            address.setKommune(kommune);
        }
    }
}
