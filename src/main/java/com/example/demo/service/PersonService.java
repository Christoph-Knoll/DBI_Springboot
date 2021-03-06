package com.example.demo.service;

import com.example.demo.dto.AddressDTO;
import com.example.demo.dto.AwesomePeopleCountDTO;
import com.example.demo.dto.PersonDTO;
import com.example.demo.mapper.PersonMapper;
import com.example.demo.model.PersonBO;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    //private final BoundMapperFacade<PersonDTO, PersonBO> mapper = new DefaultMapperFactory.Builder().build()
    //        .getMapperFacade(PersonDTO.class, PersonBO.class);

    @Autowired
    public PersonService(@Qualifier("personRepo") PersonRepository personRepo) {
        this.personRepository = personRepo;
    }

    public void addPerson(PersonDTO personDTO) {
        var person = PersonBO.createNew(personDTO.getSSN(), personDTO.getDateOfBirth(),
                personDTO.getFirstName(), personDTO.getLastName(), personDTO.isAwesome(),
                personDTO.getAwesomeness(), personDTO.getWealth());
        personRepository.insertPerson(person);
    }

    public void updatePerson(PersonDTO personDTO) {
        var person = PersonMapper.map(personDTO);
        personRepository.updatePerson(person);
    }

    public void addAddress(AddressDTO addressDTO){
        var person = getById(addressDTO.getSSN());
        person.getAddresses().add(addressDTO);
        updatePerson(person);
    }
    public List<PersonDTO> getAllPeople() {
        var people = personRepository.getAllPeople();
        return people.stream().map(PersonMapper::map).collect(Collectors.toList());
    }

    public PersonDTO getById(String SSN) {
        return PersonMapper.map(personRepository.getBySSN(SSN));
    }

    public List<AwesomePeopleCountDTO> getAwesomePeopleCount(){
        return personRepository.getAwesomePeopleCount();
    }

    public List<String> getCities(){
        return personRepository.getCities();
    }
}
