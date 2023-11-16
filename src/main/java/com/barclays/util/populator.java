package com.barclays.util;

import com.barclays.model.HolidaySeason;
import com.barclays.model.Message;
import com.barclays.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class populator {
    private MessageRepository messageRepository;

   // @EventListener(ContextRefreshedEvent.class)
    public void populate(){

        Message christmasMessage = new Message();
        christmasMessage.setContent("MerryChristmas ");

        HolidaySeason christmasSeason = new HolidaySeason();
        christmasSeason.setHolidaySeason("Christmas");

        christmasMessage.setHolidaySeason(christmasSeason);
        messageRepository.save(christmasMessage);

        Message easterMessage = new Message();
        easterMessage.setContent("Happy Easter ");
        messageRepository.save(easterMessage);



//        Message m1 = new Message("Tolu Applied to Barclays");
//        messageRepository.save(m1);
//
//        Message m2 = new Message("Tolu got the job at  Barclays");
//        messageRepository.save(m2);
//
//        Message m3 = new Message("Tolu started the job at  Barclays");
//        messageRepository.save(m3);
//
//        Message m4 = new Message("Does Tolu like Barclays? ");
//        messageRepository.save(m4);
    }

}
