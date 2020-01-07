package com.example.demo.mapper;

import com.example.demo.dto.PersonDTO;
import com.example.demo.model.PersonBO;

import java.util.stream.Collectors;

public abstract  class PersonMapper {
    public static PersonBO map(PersonDTO personDTO){
        var person = PersonBO.createNew(
                personDTO.getSSN(),
                personDTO.getDateOfBirth(),
                personDTO.getFirstName(),
                personDTO.getLastName(),
                personDTO.isAwesome(),
                personDTO.getAwesomeness(),
                personDTO.getWealth()
        );

        person.setAddresses(personDTO.getAddresses().stream().map(a -> AddressMapper.map(a,person))
                .collect(Collectors.toList()));

        return person;
    }

    public static PersonDTO map(PersonBO personBO){
        return new PersonDTO(personBO.getSSN(),
                personBO.getDateOfBirth(),
                personBO.getFirstName(),
                personBO.getLastName(),
                personBO.isAwesome(),
                personBO.getAwesomeness(),
                personBO.getWealth(),
                personBO.getAddresses().stream().map(AddressMapper::map)
                        .collect(Collectors.toList()));
    }
}
