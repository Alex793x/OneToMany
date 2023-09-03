package com.example.onetomanyexample.addresser.repository;

import com.example.onetomanyexample.addresser.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AddressRepository extends JpaRepository<Address, String> {
}
