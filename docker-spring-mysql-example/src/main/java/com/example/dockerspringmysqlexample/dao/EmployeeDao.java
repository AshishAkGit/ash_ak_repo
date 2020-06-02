package com.example.dockerspringmysqlexample.dao;

import com.example.dockerspringmysqlexample.model.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> getAllEmployees();
    void insertEmployee(Employee employee);
}
