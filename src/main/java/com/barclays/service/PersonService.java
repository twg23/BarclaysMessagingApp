package com.barclays.service;

import com.barclays.model.Message;
import com.barclays.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> getPeople();

    Person getPersonNameBasedOnId(int id);


    List<Person> findByPersonNameNotContaining(String filter);

    List<Person> findByPersonNameContainsIgnoreCase(String filter);

    List<Person> searchByName(String name);
}
