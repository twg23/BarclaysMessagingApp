package com.barclays.service;

import com.barclays.model.Message;

import java.util.List;

public interface MessageService {
    List<Message> findAll();

    Message findByID(int id);

    List<Message> findByContentContains(String filter);
}

