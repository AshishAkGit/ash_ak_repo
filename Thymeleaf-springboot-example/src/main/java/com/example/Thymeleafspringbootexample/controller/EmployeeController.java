package com.example.Thymeleafspringbootexample.controller;

import com.example.Thymeleafspringbootexample.exception.RecordNotFoundException;
import com.example.Thymeleafspringbootexample.model.Employee;
import com.example.Thymeleafspringbootexample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class EmployeeController {
    @Autowired
    EmployeeService service;

    @RequestMapping
    public String getAllEmployees(Model model){
       List<Employee> employeeList= service.getAllEmployees();
       model.addAttribute("employees",employeeList);
        return "list-employees";
    }

    @RequestMapping(path = {"/edit", "/edit/{id}"})
    public String editEmployeeById(Model model,@PathVariable("id") final Optional<Long> id) throws RecordNotFoundException {
        if(id.isPresent()){
            Employee entity=service.getEmployeeById(id.get());
            model.addAttribute("employee",entity);
        }else{
            model.addAttribute("employee", new Employee());
        }
        return "add-edit-employee";
    }
    @RequestMapping(path = "/delete/{id}")
    public String deleteEmployeeById(Model model, @PathVariable("id") Long id)
            throws RecordNotFoundException
    {
        service.deleteEmployeeById(id);
        return "redirect:/";
    }

    @RequestMapping(path = "/createEmployee", method = RequestMethod.POST)
    public String createOrUpdateEmployee(Employee employee)
    {
        service.createOrUpdateEmployee(employee);
        return "redirect:/";
    }
}


