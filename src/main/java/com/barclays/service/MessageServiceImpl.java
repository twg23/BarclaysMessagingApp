package com.barclays.service;

import com.barclays.model.Message;
import com.barclays.repository.MessageRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service // always annotes
@Slf4j
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {

    private MessageRepository messageRepository;

//    @Override
//    public List<Message> findAll(){ //hibernate JPA
//        List<Message> messages =new ArrayList<>();
//        Message message = new Message();
//        message.setContent("Spring is cool");
//        Message message1 = new Message();
//        message1.setContent("I love Java ");
//        messages.add(message);
//        messages.add(message1);
//        return messages;
//    }

    @Override
    public List<Message> findAll(){ //hibernate JPA
        List<Message> messages =new ArrayList<>();
        Iterable<Message> messagesIts = messageRepository.findAll();// provides iterable list which we dont want on UI
        messagesIts.forEach(messages:: add);// lambda into a arraylist and return an arrylist
        return messages;

    }

    @Override
    public Message findByID(int id){
        Optional<Message> message =  messageRepository.findById(id);
        return message.orElseGet(() ->  new Message("Default Message: Nothing found"));
    }

    @Override
    public List<Message> findByContentContains(String filter) {
        return messageRepository.findByContentContains(filter);
    }
//     @Override
//     public Message findByID(int id){
//         Message message = new Message("hello");
//         if (id == 1) {
//             message.setContent("tolu" + id);
//         } else if (id == 2) {
//             message.setContent("Bryan is a good teacher: " + id);
//         } else {
//
//         }
//         return message;
//     }
}
