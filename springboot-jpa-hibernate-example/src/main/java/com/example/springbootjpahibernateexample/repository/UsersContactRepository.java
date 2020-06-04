package com.example.springbootjpahibernateexample.repository;

import com.example.springbootjpahibernateexample.model.UsersContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersContactRepository extends JpaRepository<UsersContact,Integer> {
}
