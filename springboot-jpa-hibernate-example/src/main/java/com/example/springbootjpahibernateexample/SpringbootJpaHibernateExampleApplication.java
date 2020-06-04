package com.example.springbootjpahibernateexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*
	OnetoOne Mapping in Hibernate between Users and UsersContact
 */

@EnableJpaRepositories("com.example.springbootjpahibernateexample.repository")
@SpringBootApplication
public class SpringbootJpaHibernateExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaHibernateExampleApplication.class, args);
	}

}
