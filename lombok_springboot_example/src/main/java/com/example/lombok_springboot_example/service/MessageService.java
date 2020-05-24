package com.example.lombok_springboot_example.service;

import com.example.lombok_springboot_example.dto.MessageDto;
import com.sun.istack.internal.NotNull;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    public MessageDto getSubscriptionMessage(@NotNull String user){
        MessageDto message=new MessageDto();
        message.setId(Long.valueOf(1));
        message.setMessage("Hello "+user+", Thanks for the subscription!");

        return message;
    }
}
