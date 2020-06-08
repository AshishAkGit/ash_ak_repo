package com.example.springbootpersonexamplejava11.dao;

import com.example.springbootpersonexamplejava11.model.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Qualifier("postgresData")
public class PostgresDataPersonDaoImpl implements PersonDao{

    private JdbcTemplate jdbcTemplate;

    public PostgresDataPersonDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(UUID id, Person person) {
        final String sql="INSERT INTO person(id,name) VALUES(?,?)";
        return jdbcTemplate.update(sql,UUID.randomUUID(),person.getName());
    }

    @Override
    public List<Person> getAllPeople() {
        final String sql="SELECT id,name FROM person";
        return jdbcTemplate.query(sql,(resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            return new Person(id,name);
            });
    }

    @Override
    public Optional<Person> getPersonById(UUID id) {
        final String sql="SELECT id,name FROM person WHERE id = ?";
        Person person=jdbcTemplate.queryForObject(sql,new Object[]{id},(resultSet, i) -> {
            UUID personId = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            return new Person(personId,name);
        });
        return Optional.ofNullable(person);
    }

    @Override
    public int deleteById(UUID id) {
        final String sql="DELETE FROM person WHERE id = ?";
          int status =jdbcTemplate.update(sql,id);
          if(status !=0 ){
              System.out.println("Employer data deleted for :"+id);
          }else{
              System.out.println("No employee found for :"+id);
          }
        return status;
    }

    @Override
    public int updatePerson(UUID id, Person person) {
        final String sql="UPDATE person SET name = ? WHERE id = ?";
        int status =jdbcTemplate.update(sql,person.getName(),id);
        if(status !=0 ){
            System.out.println("Employer data updated for :"+id);
        }else{
            System.out.println("No employee found for :"+id);
        }
        return status;
    }
}
