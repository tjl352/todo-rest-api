package com.example.todorestapi.controllers;

import com.example.todorestapi.entities.Todo;
import com.example.todorestapi.services.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController {

    private Logger logger = LoggerFactory.getLogger(TodoController.class);

    @Autowired
    TodoService todoService;

    @PostMapping("/todo")
    public Todo addTodo(@RequestBody Todo todo){
        logger.info("addTodo called");
        return todoService.addTodo(todo);
    }

    @PutMapping("/todo")
    public Todo updateTodo(@RequestBody Todo todo){
        logger.info("updateTodo called");
        return todoService.updateTodo(todo);
    }

    @DeleteMapping("/todo")
    public void deleteTodo(@RequestBody Todo todo){
        logger.info("deleteTodo called");
        todoService.deleteTodo(todo);
    }

    @GetMapping("/todo/{id}")
    public Todo getTodoById(@PathVariable Long id){
        logger.info("getTodobyId called");
        return todoService.getTodoById(id);
    }
}
