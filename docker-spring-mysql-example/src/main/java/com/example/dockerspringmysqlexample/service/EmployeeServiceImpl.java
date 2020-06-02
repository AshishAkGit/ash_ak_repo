package com.example.dockerspringmysqlexample.service;

import com.example.dockerspringmysqlexample.dao.EmployeeDao;
import com.example.dockerspringmysqlexample.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao dao;

    @Override
    public List<Employee> getAllEmployees() {
        return dao.getAllEmployees();
    }

    @Override
    public void insertEmployee(Employee employee) {
            dao.insertEmployee(employee);
    }
}
