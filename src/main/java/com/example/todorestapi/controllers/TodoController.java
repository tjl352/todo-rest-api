package com.example.todorestapi.controllers;

import com.example.todorestapi.entities.Todo;
import com.example.todorestapi.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    @Autowired
    TodoService todoService;

    @PostMapping("/todo")
    public Todo addTodo(@RequestBody Todo todo){
        return todoService.addTodo(todo);
    }
}
