package com.barclays.controller;

import com.barclays.model.Message;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonControllerTest {

        @Test
        public void testGetAllMessage(){
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Message[]> response =
                    restTemplate.getForEntity("http://localhost:8080/people", Message[].class);
            Message[] messages = response.getBody();
            assertEquals(messages.length, 3);
        }

//        @Test
//        public void testGetAllMessageWithFilter(){
//            RestTemplate restTemplate = new RestTemplate();
//            ResponseEntity<Message> response =
//                    restTemplate.getForEntity("http://localhost:8080/messages/1?filter=unread", Message.class);
//            Message messages = response.getBody();
//            assertEquals("tolu", messages.getContent());
//            //assertEquals(messages.length, 1);
//            //assertNotNull(messages);
//        }


    }

