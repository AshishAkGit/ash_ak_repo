package com.example.springbootjsondbexample.controller;


import com.example.springbootjsondbexample.domain.User;
import com.example.springbootjsondbexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public Iterable<User> list(){
        return userService.list();
    }


}
