package com.example.helloworld.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.example.helloworld.entity.Message;
import com.example.helloworld.service.MessageService;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HelloWorldController.class)
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MessageService messageService;

    @Test
    void testHello_ShowsMessage() throws Exception {
        when(messageService.getMessage()).thenReturn(new Message("Hello World"));

        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("message"))
                .andExpect(model().attribute("message", "Hello World"))
                .andExpect(view().name("index"));
    }

    @Test
    void testHello_ShowsError() throws Exception {
        when(messageService.getMessage()).thenReturn(new Message("Error: DB not reachable"));

        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("message"))
                .andExpect(model().attribute("message", "Error: DB not reachable"))
                .andExpect(view().name("index"));
    }
}

