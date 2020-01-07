package com.example.demo.repository;

import com.example.demo.dto.AwesomePeopleCountDTO;
import com.example.demo.model.PersonBO;

import java.util.List;

public interface PersonRepository {
    void insertPerson(PersonBO person);
    void updatePerson(PersonBO person);

    List<PersonBO> getAllPeople();
    PersonBO getBySSN(String SSN);
    List<AwesomePeopleCountDTO> getAwesomePeopleCount();
    List<String> getCities();
}
