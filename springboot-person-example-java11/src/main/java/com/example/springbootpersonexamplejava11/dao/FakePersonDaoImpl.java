package com.example.springbootpersonexamplejava11.dao;

import com.example.springbootpersonexamplejava11.model.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Qualifier("FakeData")
public class FakePersonDaoImpl implements PersonDao {

    private static List<Person> db=new ArrayList<>();
    @Override
    public int insertPerson(UUID id, Person person) {
        db.add(new Person(id,person.getName()));
        return 1;
    }

    @Override
    public List<Person> getAllPeople() {
        return db;
    }



    @Override
    public Optional<Person> getPersonById(UUID id) {
         return db.stream().filter(person -> person.getId().equals(id))
                 .findFirst();
    }

    @Override
    public int deleteById(UUID id) {
        Optional<Person> personMaybe = getPersonById(id);
        if(personMaybe.isEmpty()){
            return 0;
        }
        db.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePerson(UUID id, Person update) {
        return getPersonById(id)
                .map(person -> {
                    int indexOfPersonToUpdate=db.indexOf(person);
                    if(indexOfPersonToUpdate >= 0){
                        db.set(indexOfPersonToUpdate,new Person(id,update.getName()));
                         return 1;
                    }
                        return 0;
                }).orElse(0);
    }

}
