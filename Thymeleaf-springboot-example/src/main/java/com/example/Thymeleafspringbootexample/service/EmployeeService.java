package com.example.Thymeleafspringbootexample.service;

import com.example.Thymeleafspringbootexample.exception.RecordNotFoundException;
import com.example.Thymeleafspringbootexample.model.Employee;
import com.example.Thymeleafspringbootexample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository repository;

    public List<Employee> getAllEmployees(){
       List<Employee> result=(List<Employee>)  repository.findAll();
       if(result.size()>0){
           return result;
       }else{
           return new ArrayList<Employee>();
       }
    }

    public Employee getEmployeeById(Long id) throws RecordNotFoundException {
       Optional<Employee> employee= repository.findById(id);
       if(employee.isPresent()){
           return employee.get();
       }else{
           throw new RecordNotFoundException("No employee record exist for given id");
       }
    }

    public Employee createOrUpdateEmployee(Employee entity){
        if(entity.getId() == null){
           entity= repository.save(entity);
            return entity;
        }
        else{
           Optional<Employee> employee= repository.findById(entity.getId());
           if(employee.isPresent()){
              Employee newEntity= employee.get();
               newEntity.setId(entity.getId());
               newEntity.setFirstName(entity.getFirstName());
               newEntity.setLastName(entity.getLastName());
               newEntity.setEmail(entity.getEmail());
               newEntity.setNow(new Date());
               newEntity = repository.save(newEntity);
               return newEntity;
           }
           else{
               entity=repository.save(entity);
               return entity;
           }
        }
    }

    public void deleteEmployeeById(Long id) throws RecordNotFoundException {
        Optional<Employee> employee=repository.findById(id);
        if(employee.isPresent()){
            repository.delete(employee.get());
        }else{
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }

}
