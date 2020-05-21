package com.example.springbootjsondbexample.service;

import com.example.springbootjsondbexample.domain.User;
import com.example.springbootjsondbexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Iterable<User> list(){
        return userRepository.findAll();
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public Iterable<User> save(List<User> users){
            return userRepository.saveAll(users);

    }
}
