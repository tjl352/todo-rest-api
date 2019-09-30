package com.example.todorestapi.controllers;

import com.example.todorestapi.entities.Todo;
import com.example.todorestapi.services.TodoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class TodoControllerTests {

    @Autowired
    MockMvc mvc;

    @Autowired
    TodoService todoService;

    @Test
    public void getTodo() throws Exception{
        long id = todoService.addTodo(new Todo("walk dog")).getId();
        mvc.perform(get("/todo/" +id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("walk dog"));
    }

    @Test
    public void addTodo() throws Exception {
        mvc.perform(post("/todo")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"message\":\"walk dog\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("walk dog"));
    }

    @Test
    public void updateTodo() throws Exception{
        todoService.addTodo(new Todo("talk out trash"));
        mvc.perform(put("/todo")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"message\":\"walk dog\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("walk dog"));
    }

    @Test
    public void deleteTodo() throws Exception{
        todoService.addTodo(new Todo("walk dog"));
        mvc.perform(delete("/todo")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"message\":\"walk dog\"}"))
                .andExpect(status().isOk());
    }
}
