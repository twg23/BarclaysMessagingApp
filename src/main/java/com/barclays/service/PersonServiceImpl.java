package com.barclays.service;

import com.barclays.model.Person;
import com.barclays.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor

public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

//    @Override
//    public List<Person> getPeople(){
//        List<Person> people = new ArrayList<>();
//        Person person= new Person();
//        person.setPersonName("Victoria Secret");
//        person.setEmailAddress("vs@gmail.com");
//        people.add(person);
//        return people;
//    }
    @Override
    public List<Person> getPeople(){
        List<Person> people = new ArrayList<>();
        Iterable<Person> personIts = personRepository.findAll();
        personIts.forEach(people:: add);

        return people;
    }

    @Override
    public  Person getPersonNameBasedOnId(int id){
        Optional<Person> person = personRepository.findById(id);
        return person.orElseGet(() ->  new Person(0,"No Name found", "No email found"));
    }

    @Override
    public List<Person> findByPersonNameNotContaining(String filter) {
        return personRepository.findByPersonNameNotContaining(filter);
    }

    @Override
    public List<Person> findByPersonNameContainsIgnoreCase(String filter) {
        return personRepository.findByPersonNameContainsIgnoreCase(filter);
    }
    public List<Person> searchByName(String name) {
        return personRepository.searchByName(name);
    }


}
