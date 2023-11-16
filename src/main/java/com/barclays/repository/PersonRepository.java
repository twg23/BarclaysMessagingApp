package com.barclays.repository;

import com.barclays.model.Message;
import com.barclays.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
    List<Person> findByPersonNameContainsIgnoreCase(String filter);
    List<Person> findByPersonNameNotContaining(String filter);
    @Query("SELECT new Person(p.personName,p.emailAddress) " + //java persistence querry language
            "FROM Person p WHERE p.personName LIKE %:personName%")
    List<Person> searchByName(@Param("personName") String  personName);

}
