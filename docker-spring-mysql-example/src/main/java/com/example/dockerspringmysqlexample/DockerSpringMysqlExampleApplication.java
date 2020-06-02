package com.example.dockerspringmysqlexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.example.repository")
@SpringBootApplication
public class DockerSpringMysqlExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerSpringMysqlExampleApplication.class, args);
	}

}
