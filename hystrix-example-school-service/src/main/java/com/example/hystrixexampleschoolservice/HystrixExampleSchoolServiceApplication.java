package com.example.hystrixexampleschoolservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
@EnableCircuitBreaker
public class HystrixExampleSchoolServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixExampleSchoolServiceApplication.class, args);
	}

}
