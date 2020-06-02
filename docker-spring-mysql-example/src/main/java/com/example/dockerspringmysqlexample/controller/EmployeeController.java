package com.example.dockerspringmysqlexample.controller;

import com.example.dockerspringmysqlexample.model.Employee;
import com.example.dockerspringmysqlexample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService empService;


    @GetMapping("/employees")
    public List<Employee> getEmployees() {

        return empService.getAllEmployees();

    }

    @PostMapping("/insertemployee")
    public void insertEmployee(@RequestBody Employee employee) {
        empService.insertEmployee(employee);
    }


}
