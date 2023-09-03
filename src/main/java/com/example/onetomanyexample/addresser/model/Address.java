package com.example.onetomanyexample.addresser.model;

import com.example.onetomanyexample.kommune.model.Kommune;
import com.example.onetomanyexample.region.model.Region;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonDeserialize(using = AddressDTO.class)
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Address {

    @Id
    private String id;

    private String floor;

    private String door;

    private String roadName;

    private String houseNum;

    private String zipNum;

    private String zipName;

    @Transient
    private String regionCode;

    @Transient
    private String communeCode;


    @ManyToOne
    @JoinColumn(name = "region_code", referencedColumnName = "code")
    private Region region;

    @ManyToOne
    @JoinColumn(name = "kommune", referencedColumnName = "code")
    private Kommune kommune;
}
