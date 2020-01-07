package com.example.demo.model.data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Address extends EntityBase {
    @EmbeddedId
    private AddressId id = new AddressId();
    private String city;
    private String country;
    private String street;
    // @Column annotation needed to tell the ORM in which column the field belongs.
    @Column(name = "street_no")
    private int streetNumber;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public Integer getId(){
        return this.id.getId();
    }

    public void setId(Integer id){
        // Needed to use Generated value
        if (id == null) this.id.setId(id);
    }

    public Person getPerson(){
        return this.id.getPerson();
    }

    public void setPerson(Person person){
        this.id.setPerson(person);
    }

}

@Embeddable
class AddressId implements Serializable {
    //region Fields
    // @Column annotation needed to tell the ORM in which column the field belongs.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_no")
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "ssn")
    private Person person;
    //endregion

    //region Constructors
    public AddressId(Person person) {
        this.person = person;
    }

    public AddressId() {
    }
    //endregion

    //region Props
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    //endregion

}