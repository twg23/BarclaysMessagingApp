package com.barclays.repository;

import com.barclays.model.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message,Integer> {
    //CRUDREPO  defines  various methods E.G , takes a type &ID
    List<Message> findByContentContains(String filter);
}
