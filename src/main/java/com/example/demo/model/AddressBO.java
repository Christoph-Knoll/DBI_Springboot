package com.example.demo.model;

import com.example.demo.model.data.Address;
import com.example.demo.model.data.Person;

public class AddressBO extends RootBO<Address>{

    public AddressBO(Address state) {
        super(state);
    }

    public static AddressBO createNew(Integer id, PersonBO person, String city, String country, String street, Integer streetNumber) {
        var ad = new Address();
        ad.setId(id);
        ad.setPerson(person.getState());
        ad.setCity(city);
        ad.setCountry(country);
        ad.setStreet(street);
        ad.setStreetNumber(streetNumber);
        return new AddressBO(ad);
    }

    public Integer getId() {
        return this.state.getId();
    }

    public Person getPerson() {
        return this.state.getPerson();
    }

    public String getCity() {
        return this.state.getCity();
    }

    public String getCountry() { return this.state.getCountry(); }

    public String getStreet() { return this.state.getStreet(); }

    public Integer getStreetNumber() { return this.state.getStreetNumber(); }

}
