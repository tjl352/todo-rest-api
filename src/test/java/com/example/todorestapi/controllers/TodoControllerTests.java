package com.example.todorestapi.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class TodoControllerTests {

    @Autowired
    MockMvc mvc;

    @Test
    public void addTodo() throws Exception {
        mvc.perform(post("/todo")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"message\":\"walk dog\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("walk dog"));
    }
}
