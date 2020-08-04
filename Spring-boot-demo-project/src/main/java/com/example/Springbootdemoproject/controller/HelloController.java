package com.example.Springbootdemoproject.controller;

import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerEndpoint(id="hello")
@RestController
public class HelloController {
    @GetMapping("/hello")
    public Map<String,String> getDate(){
        Map<String,String> map=new HashMap<>();
        map.put("server.date",LocalDate.now().toString());
        map.put("server.time", LocalTime.now().toString());
        return map;
    }
}
