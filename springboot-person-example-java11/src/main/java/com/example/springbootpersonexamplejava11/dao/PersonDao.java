package com.example.springbootpersonexamplejava11.dao;

import com.example.springbootpersonexamplejava11.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PersonDao {
    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person){
       UUID id= UUID.randomUUID();
       return insertPerson(id,person);
    }
    List<Person> getAllPeople();
    Optional<Person> getPersonById(UUID id);
    int deleteById(UUID id);
    int updatePerson(UUID id,Person person);
}
