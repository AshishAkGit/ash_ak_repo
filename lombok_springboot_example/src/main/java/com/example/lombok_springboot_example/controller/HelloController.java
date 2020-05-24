package com.example.lombok_springboot_example.controller;

import com.example.lombok_springboot_example.dto.MessageDto;
import com.example.lombok_springboot_example.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *  This class is to test Lombok functionality
 *  in spring boot. UrL to test in browser
 *  http://localhost:8081/hello?user="Peter"
 */
@Slf4j
@RestController
public class HelloController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/hello")
    public MessageDto sayHello(@RequestParam String user) {

        log.info("test info log: " + user);

        MessageDto message = messageService.getSubscriptionMessage(user);

        log.debug("test debug log : " + message.toString());

        return message;
    }
}
