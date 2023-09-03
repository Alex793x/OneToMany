package com.example.onetomanyexample.addresser.service;

import com.example.onetomanyexample.addresser.model.Address;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class ApiServiceGetAddressImpl implements ApiServiceGetAddress{

    // Url for all addresses in Virum
    String virumUrl = "https://api.dataforsyningen.dk/adresser?postnr=2830";

    // Field inject Service and RestTemplate
    private final AddressService addressService;
    private final RestTemplate restTemplate;
    private final AddressMapper addressMapper;

    // Constructor ----------------------------------------------------------
    public ApiServiceGetAddressImpl(AddressService addressService, RestTemplate restTemplate, AddressMapper addressMapper) {
        this.addressService = addressService;
        this.restTemplate = restTemplate;
        this.addressMapper = addressMapper;
    }


    public void saveAddress(List<Address> addresses) {
        addressService.saveAddress(addresses);
    }


    @Override
    public List<Address> getAddress() {
        ResponseEntity<List<Address>> regionResponse = restTemplate.exchange(
                virumUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Address>>() {}
        );

        List<Address> addresses = Optional.ofNullable(regionResponse.getBody()).orElse(Collections.emptyList());

        // Map Region and Kommune
        addresses.forEach(addressMapper::mapRelationships);
        saveAddress(addresses);
        return addresses;
    }

}
