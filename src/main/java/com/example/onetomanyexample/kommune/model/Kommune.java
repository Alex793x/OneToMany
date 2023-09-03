package com.example.onetomanyexample.kommune.model;

import com.example.onetomanyexample.addresser.model.Address;
import com.example.onetomanyexample.region.model.Region;
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
public class Kommune {

    @Id
    @JsonProperty("dagi_id")
    private int dagiId;

    @Column(length = 4)
    @JsonProperty("kode")
    private int code;

    @JsonProperty("navn")
    private String name;

    private String href;

    @JsonProperty("udenforkommuneinddeling")
    private boolean outOfCommune;

    @ManyToOne
    @JoinColumn(name = "region", referencedColumnName = "code")
    Region region;


    @OneToMany(mappedBy = "kommune", cascade = CascadeType.ALL)
    @JsonBackReference("address-commune")
    private Set<Address> addressSet = new HashSet<>();

}
