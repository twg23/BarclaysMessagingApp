package com.barclays.util;

import com.barclays.model.Address;
import com.barclays.model.Message;
import com.barclays.model.Person;
import com.barclays.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class populatePeople {
    private PersonRepository personRepository;
   // @EventListener(ContextRefreshedEvent.class)
    public void populatePerson(){
        Person person = new Person();
        person.setPersonName("Bryan Hansen");
        person.setEmailAddress(" bryanhansen@gmail.com");

        Address address =new Address();
        address.setLineOne("123 Tom st");
        address.setLineTwo("Unit G");
        address.setState("UTAH");
        address.setPostalCode("84065");
        address.setCountry("USA");

        person.setAddress(address);
        personRepository.save(person);

        Person person1 = new Person();
        person1.setPersonName("Bill Fairfield");
        person1.setEmailAddress( "billfairfield@gmail.com");

        personRepository.save(person1);


//        Person  person2 = new Person(120, "Bill Fairfield", " billfairfield@gmail.com");
//        personRepository.save(p2);


    }
}
