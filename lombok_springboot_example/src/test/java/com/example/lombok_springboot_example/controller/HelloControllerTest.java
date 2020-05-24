package com.example.lombok_springboot_example.controller;

import com.example.lombok_springboot_example.dto.MessageDto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    @DisplayName("/hello RestAPI test ")
    void testMessage(){
        String user="Peter";
        URI targetUrl= UriComponentsBuilder.fromUriString("/hello")
                .queryParam("user", user)
                .build()
                .encode()
                .toUri();
        MessageDto message = this.restTemplate.getForObject(targetUrl, MessageDto.class);
        assertEquals("Hello "+user+", Thanks for the subscription!", message.getMessage());
    }

}