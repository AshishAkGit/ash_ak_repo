package com.example.springbootjsondbexample;

import com.example.springbootjsondbexample.domain.User;
import com.example.springbootjsondbexample.service.UserService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class SpringbootJsonDbExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJsonDbExampleApplication.class, args);
	}



	@Bean
	CommandLineRunner runner(UserService userService){
		return  args -> {
			//read Json and write to db.
			ObjectMapper mapper=new ObjectMapper();
			TypeReference<List<User>> typeReference=new TypeReference<List<User>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/users.json");
			try{
				 List<User> users=mapper.readValue(inputStream,typeReference);
				 userService.save(users);
				System.out.println("Users saved.");
			}catch (IOException ioException){
				System.out.println("Unable to save users "+ ioException.getMessage());
			}

		};
	}
}
