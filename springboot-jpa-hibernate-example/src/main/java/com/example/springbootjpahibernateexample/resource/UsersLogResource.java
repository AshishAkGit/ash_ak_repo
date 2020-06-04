package com.example.springbootjpahibernateexample.resource;

import com.example.springbootjpahibernateexample.model.Users;
import com.example.springbootjpahibernateexample.model.UsersLog;
import com.example.springbootjpahibernateexample.repository.UsersLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/users/log")
public class UsersLogResource {

    @Autowired
    UsersLogRepository usersLogRepository;

    @GetMapping
    public List<UsersLog> getAll(){
        return usersLogRepository.findAll();
    }

    @GetMapping("/update/{name}")
    public List<UsersLog> update(@PathVariable final String name){
        Users users=new Users();
        users.setName(name);
        users.setSalary(12000);
        UsersLog usersLog=new UsersLog();
        UsersLog usersLog2=new UsersLog();
        usersLog.setUsers(users);
        usersLog.setLog("Hi Youube");
        usersLogRepository.save(usersLog);
        usersLog2.setUsers(users);
        usersLog2.setLog("Hi FB");
        usersLogRepository.save(usersLog2);
        return usersLogRepository.findAll();
    }

}
