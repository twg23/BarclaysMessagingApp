package com.barclays.controller;

import com.barclays.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonControllerSpringIntegrationTest {
    @Autowired
    PersonController personController;
    @Test
    public void testGettingTheNameOfEachPerson(){
        Person person = personController.getPeople(300);
        assertEquals("Tolu Adetomiwa", person.getPersonName());


    }

    @Test
    public void testGettingTheEmailOfEachPerson(){
        Person person = personController.getPeople(310);
        assertEquals("tiseoludayomia@gmail.com", person.getEmailAddress());


    }


    
}
