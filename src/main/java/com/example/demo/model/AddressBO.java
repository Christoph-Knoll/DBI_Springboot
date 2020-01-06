package com.example.demo.model;

import com.example.demo.model.data.Address;

public class AddressBO extends RootBO<Address>{

    public AddressBO(Address state) {
        super(state);
    }

    public static AddressBO createNew(String city, String country, String street, int streetNumber) {
        var ad = new Address();
        ad.setCity(city);
        ad.setCountry(country);
        ad.setStreet(street);
        ad.setStreetNumber(streetNumber);
        return new AddressBO(ad);
    }

    public String getCity() {
        return this.state.getCity();
    }

    public String getCountry() { return this.state.getCountry(); }

    public String getStreet() { return this.state.getStreet(); }

    public String getStreetNumber() { return this.state.getCountry(); }
}
