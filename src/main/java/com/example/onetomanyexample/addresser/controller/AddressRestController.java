package com.example.onetomanyexample.addresser.controller;

import com.example.onetomanyexample.addresser.model.Address;
import com.example.onetomanyexample.addresser.service.AddressService;
import com.example.onetomanyexample.addresser.service.ApiServiceGetAddress;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressRestController {
    // Test



    // Field Injecting Service Layer
    private final AddressService addressService;
    private final ApiServiceGetAddress apiServiceGetAddress;


    // Constructor ------------------------------------------
    public AddressRestController(AddressService addressService, ApiServiceGetAddress apiServiceGetAddress) {
        this.addressService = addressService;
        this.apiServiceGetAddress = apiServiceGetAddress;
    }


    // Mappings ----------------------------------------------
    @GetMapping("/addresses")
    public List<Address> getAddress() {
        return apiServiceGetAddress.getAddress();
    }
}
