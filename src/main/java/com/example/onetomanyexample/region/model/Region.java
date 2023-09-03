package com.example.onetomanyexample.region.model;

import com.example.onetomanyexample.addresser.model.Address;
import com.example.onetomanyexample.kommune.model.Kommune;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Region {

    @Id
    @JsonProperty("dagi_id")
    private int dagiId;

    @JsonProperty("kode")
    private int code;

    @JsonProperty("navn")
    private String name;

    @JsonProperty("nuts2")
    private String nutsName;

    private String href;


    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Kommune> communes = new HashSet<>();

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    @JsonBackReference("address-region")
    private Set<Address> addresses = new HashSet<>();

}
