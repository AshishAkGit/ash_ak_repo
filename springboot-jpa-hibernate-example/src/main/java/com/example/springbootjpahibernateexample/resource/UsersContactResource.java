package com.example.springbootjpahibernateexample.resource;

import com.example.springbootjpahibernateexample.model.Users;
import com.example.springbootjpahibernateexample.model.UsersContact;
import com.example.springbootjpahibernateexample.model.UsersLog;
import com.example.springbootjpahibernateexample.repository.UsersContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rest/userscontact")
public class UsersContactResource {
    @Autowired
    UsersContactRepository usersContactRepository;

    @GetMapping("/all")
    public List<UsersContact> getUsersContact(){
        return usersContactRepository.findAll();
    }
    @GetMapping("/update/{name}")
    public List<UsersContact> update(@PathVariable("name") final String name){
        UsersContact usersContact=new UsersContact();
        UsersLog usersLog=new UsersLog();
        UsersLog usersLog2=new UsersLog();
        Users users=new Users();
        users.setSalary(5000);
        users.setName(name);
        usersLog.setLog("hi Youtube");
        usersLog2.setLog("hi Viewers");
        users.setUsersLogs(Arrays.asList(usersLog,usersLog2));
        usersContact.setPhoneNo(111);
        usersContact.setUsers(users);
        usersContactRepository.save(usersContact);
        return usersContactRepository.findAll();
    }
}
