package com.example.Thymeleafspringbootexample.repository;

import com.example.Thymeleafspringbootexample.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {
}
