package com.example.springbootjpahibernateexample.repository;

import com.example.springbootjpahibernateexample.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {
    Users findByName(String name);
}
