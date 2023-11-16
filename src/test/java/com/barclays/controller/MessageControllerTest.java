package com.barclays.controller;

import com.barclays.model.Message;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class MessageControllerTest {

    @Test
    public void testGetAllMessage(){
         RestTemplate restTemplate = new RestTemplate();
         ResponseEntity<Message[]> response =
                 restTemplate.getForEntity("http://localhost:8080/messages", Message[].class);
         Message[] messages = response.getBody();
        assertEquals(messages.length, 2);
     }

    @Test
    public void testGetAllMessageWithFilter(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Message> response =
                restTemplate.getForEntity("http://localhost:8080/messages/1?filter=unread", Message.class);
        Message messages = response.getBody();
        assertEquals("tolu", messages.getContent());
        //assertEquals(messages.length, 1);
        //assertNotNull(messages);
    }


}
