package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonDTO {

    @NotBlank
    private String SSN;
    private LocalDate dateOfBirth;
    private String firstName;
    private String lastName;
    private boolean isAwesome;
    private Double awesomeness;
    private BigDecimal wealth;
    private List<AddressDTO> addresses = new ArrayList<>();


    public PersonDTO(@JsonProperty("SSN") String ssn, @JsonProperty("dateOfBirth") LocalDate dateOfBirth,
                     @JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName,
                     @JsonProperty("isAwesome") boolean isAwesome, @JsonProperty("awesomeness") Double awesomeness,
                     @JsonProperty("wealth") BigDecimal wealth, @JsonProperty("addresses") List<AddressDTO> addresses) {
        this.SSN = ssn;
        this.dateOfBirth = dateOfBirth;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isAwesome = isAwesome;
        this.awesomeness = awesomeness;
        this.wealth = wealth;
        this.addresses = addresses;
    }
    public PersonDTO(){}


    public String getSSN() {
        return SSN;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isAwesome() {
        return isAwesome;
    }

    public Double getAwesomeness() {
        return awesomeness;
    }

    public BigDecimal getWealth() {
        return wealth;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAwesome(boolean awesome) {
        isAwesome = awesome;
    }

    public void setAwesomeness(Double awesomeness) {
        this.awesomeness = awesomeness;
    }

    public void setWealth(BigDecimal wealth) {
        this.wealth = wealth;
    }

    public List<AddressDTO> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressDTO> addresses) {
        this.addresses = addresses;
    }
}
