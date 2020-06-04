package com.example.springbootjpahibernateexample.resource;

import com.example.springbootjpahibernateexample.model.Users;
import com.example.springbootjpahibernateexample.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/users")
public class UsersResource {


    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/all")
    public List<Users> getAll(){
        return usersRepository.findAll();
    }

    @GetMapping("/{name}")
    public Users displayName(@PathVariable String name){
        return usersRepository.findByName(name);
    }
    @PostMapping("/load")
    public Users load(@RequestBody Users users){
        usersRepository.save(users);
        return usersRepository.findByName(users.getName());
    }
    @GetMapping("id//{id}")
    public Users getId(@PathVariable("id") final Long id){
       Optional<Users> optional=usersRepository.findById(id);
       if(optional.isPresent()){
           return optional.get();
       }
      else
          return null;
    }

    @GetMapping("/update/{id}/{name}")
    public Users update(@PathVariable Long id, @PathVariable String name){
        Users users = getId(id);
        users.setName(name);
        return usersRepository.save(users);
    }
    
}
