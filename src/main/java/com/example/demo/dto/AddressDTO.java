package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressDTO {
    private Integer addressNo;
    private String SSN;
    private String country;
    private String city;
    private String street;
    private Integer streetNumber;

    public AddressDTO(){}

    public AddressDTO(@JsonProperty("addressNo") Integer addressNO,
                      @JsonProperty("SSN") String SSN,
                      @JsonProperty("country") String country,
                      @JsonProperty("city") String city,
                      @JsonProperty("street") String street,
                      @JsonProperty("streetNumber") Integer streetNumber){

        this.addressNo = addressNO;
        this.SSN = SSN;
        this.country = country;
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
    }

    public Integer getAddressNo() {
        return addressNo;
    }

    public void setAddressNo(Integer addressNo) {
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

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }
}
