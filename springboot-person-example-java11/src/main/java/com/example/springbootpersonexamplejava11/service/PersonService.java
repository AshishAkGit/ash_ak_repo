package com.example.springbootpersonexamplejava11.service;

import com.example.springbootpersonexamplejava11.dao.PersonDao;
import com.example.springbootpersonexamplejava11.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("postgresData") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }
    public List<Person> getAllPeople(){
       return personDao.getAllPeople();
    }
    public Optional<Person> getPersonById(UUID id){
        return personDao.getPersonById(id);
    }
    public int deleteById(UUID id) {
        return personDao.deleteById(id);
    }
    public int updatePerson(UUID id, Person newPerson) {
        return personDao.updatePerson(id, newPerson);
    }
}
