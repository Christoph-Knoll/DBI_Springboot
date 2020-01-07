package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class AddressDTO {
    @NotBlank
    private Short addressNo;
    private String SSN;
    private String country;
    private String city;
    private String street;
    private Short streetNo;

    public AddressDTO(){}

    public AddressDTO(@JsonProperty("addressNo") Short addressNO,
                      @JsonProperty("SSN") String SSN,
                      @JsonProperty("country") String country,
                      @JsonProperty("city") String city,
                      @JsonProperty("street") String street,
                      @JsonProperty("streetNo") Short streetNo){

        this.addressNo = addressNO;
        this.SSN = SSN;
        this.country = country;
        this.city = city;
        this.street = street;
        this.streetNo = streetNo;
    }

    public short getAddressNo() {
        return addressNo;
    }

    public void setAddressNo(short addressNo) {
        this.addressNo = addressNo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public short getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(short streetNo) {
        this.streetNo = streetNo;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }
}
