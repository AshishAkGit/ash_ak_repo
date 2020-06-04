package com.example.springbootjpahibernateexample.repository;

import com.example.springbootjpahibernateexample.model.UsersLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersLogRepository  extends JpaRepository<UsersLog,Integer> {
}
