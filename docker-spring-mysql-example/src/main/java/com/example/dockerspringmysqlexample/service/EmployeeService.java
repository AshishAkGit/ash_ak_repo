package com.example.dockerspringmysqlexample.service;

import com.example.dockerspringmysqlexample.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    void insertEmployee(Employee employee);
}
