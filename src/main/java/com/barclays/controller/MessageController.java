package com.barclays.controller;

import com.barclays.model.Message;
import com.barclays.service.MessageService;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@Slf4j

public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }


//    @GetMapping("/messages")
//    public List<Message> getAllMessages(){
//        log.debug("In the getALL Messages method");
//        return messageService.findAll();
//    }

    @GetMapping("/messages")
    public List<Message> getAllMessages(@PathParam("filter")String filter){
        List<Message> messages = Collections.emptyList();
        if(StringUtils.isNotBlank(filter)){
            messages = messageService.findByContentContains(filter );
        }
        else {
            messages= messageService.findAll();
        }
        return messages;
    }

    @GetMapping("/messages/{id}")
    public Message getMessages(@PathVariable int id){
        log.debug("In the getALL Messages method" + id);
        return messageService.findByID(id);

    }

    /// message controller annoted with rest
    //constructor injection
}
