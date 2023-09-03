package com.example.onetomanyexample.addresser.model;


import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

@Getter
@Setter
public class AddressDTO extends StdDeserializer<Address> {

    private String id;

    private String floor;

    private String door;

    private String roadName;

    private String houseNum;

    private String zipNum;

    private String zipName;

    private int regionCode;

    private int communeCode;


    // Constructors -----------------------------------
    public AddressDTO() {
        this(null);
    }

    protected AddressDTO(Class<?> vc) {
        super(vc);
    }

    // Serializer ---------------------------------------
    @Override
    public Address deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        JsonNode addressNode =  jsonParser.getCodec().readTree(jsonParser);
        Address address = new Address();


        address.setId(addressNode.path("id").textValue());
        address.setHouseNum(addressNode.path("adgangsadresse").path("husnr").textValue());
        address.setRoadName(addressNode.path("adgangsadresse").path("vejstykke").path("navn").textValue());
        address.setFloor(addressNode.path("etage").textValue());
        address.setDoor(addressNode.path("dør").textValue());
        address.setZipNum(addressNode.path("adgangsadresse").path("postnummer").path("nr").textValue());
        address.setZipName(addressNode.path("adgangsadresse").path("postnummer").path("navn").textValue());
        address.setCommuneCode(addressNode.path("adgangsadresse").path("kommune").get("kode").textValue());
        address.setRegionCode(addressNode.path("adgangsadresse").get("region").get("kode").textValue());
        return address;
    }

}
