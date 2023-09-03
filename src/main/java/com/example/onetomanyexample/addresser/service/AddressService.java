package com.example.onetomanyexample.addresser.service;


import com.example.onetomanyexample.addresser.model.Address;
import com.example.onetomanyexample.addresser.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> saveAddress(List<Address> addresses) {
        return addressRepository.saveAll(addresses);
    }
}
