package com.barclays.controller;

import com.barclays.model.Message;
import com.barclays.model.Person;
import com.barclays.service.PersonService;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
@RestController
@Slf4j
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }


//    @GetMapping("/people")
//    List<Person> getPeople(){
//
//        return personService.getPeople();
//    }

    @GetMapping("/people")
    public List<Person> getPeople(@PathParam("filter")String notfilter,@PathParam("filter")String filter){
        List<Person> personList = Collections.emptyList();
        if(StringUtils.isNotBlank(filter)){
            personList = personService.findByPersonNameContainsIgnoreCase(filter );
        } else if (StringUtils.isNotBlank(notfilter)) {
            personList= personService.findByPersonNameNotContaining(notfilter);

        } else {
            personList = personService.getPeople();
        }
        return  personList ;
    }


    @GetMapping("/people/{id}")
    public Person getPeople(@PathVariable int id){

        return personService.getPersonNameBasedOnId(id);
    }

    @GetMapping("/people/search")
    public List<Person>searchByName(@PathParam("personName") String personName) {
        return personService.searchByName( personName);
    }



    }


