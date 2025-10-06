package com.example.helloworld.controller;

import com.example.helloworld.entity.Message;
import com.example.helloworld.repository.MessageRepository;
import com.example.helloworld.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/hello")
    public String hello(Model model) {
        Message message = messageService.getMessage();
        model.addAttribute("message", message.getText());
        return "index"; // maps to index.html
    }
}
