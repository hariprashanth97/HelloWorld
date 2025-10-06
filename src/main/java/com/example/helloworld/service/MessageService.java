package com.example.helloworld.service;


import com.example.helloworld.entity.Message;
import com.example.helloworld.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    /**
     * Fetches the latest message (descending by ID).
     * If no message exists, inserts default "hello".
     */
    public Message getMessage() {

        try {
            if (true) throw new RuntimeException("Simulated failure!");

            Optional<Message> optionalMessage = messageRepository.findTopByOrderByIdDesc();
            return optionalMessage.orElseGet(() -> messageRepository.save(new Message("Hello World")));
        } catch (Exception e) {
            // In case of DB error, return default message
            return new Message("Error: " + e.getMessage());
        }
    }
}

