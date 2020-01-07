package com.example.demo.repository;

import com.example.demo.dto.AwesomePeopleCountDTO;
import com.example.demo.model.PersonBO;
import com.example.demo.model.data.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Repository("personRepo")
public class PersonRepositoryImpl extends RepositoryBase<Person> implements PersonRepository {

    @Autowired
    public PersonRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void insertPerson(PersonBO person) {
        persist(person);
    }

    @Override
    public void updatePerson(PersonBO person) {
        merge(person);
    }

    @Override
    public List<PersonBO> getAllPeople() {
        var query = entityManager.createQuery("select p from Person p");
        List<Person> entities = query.getResultList();
        return entities.stream().map(PersonBO::new).collect(Collectors.toList());
    }
    @Override
    public PersonBO getBySSN(String SSN) {
        return new PersonBO(entityManager.createQuery("select p from Person p where p.SSN = :SSN",Person.class)
                .setParameter("SSN", SSN).getSingleResult());
    }
    @Override
    public List<AwesomePeopleCountDTO> getAwesomePeopleCount(){
        return entityManager.createQuery("select new com.example.demo.dto.AwesomePeopleCountDTO(p.isAwesome, count(p.SSN)) from Person p group by p.isAwesome", AwesomePeopleCountDTO.class).getResultList();
    }

    @Override
    public List<String> getCities(){
        return entityManager.createQuery("select distinct a.city from Person p join p.addresses a where p.isAwesome = true order by a.city",String.class).getResultList();
    }
}
