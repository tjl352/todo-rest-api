package com.example.todorestapi.controllers;

import com.example.todorestapi.entities.Todo;
import com.example.todorestapi.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController {

    @Autowired
    TodoService todoService;

    @PostMapping("/todo")
    public Todo addTodo(@RequestBody Todo todo){
        return todoService.addTodo(todo);
    }

    @PutMapping("/todo")
    public Todo updateTodo(@RequestBody Todo todo){
        return todoService.updateTodo(todo);
    }

    @DeleteMapping("/todo")
    public void deleteTodo(@RequestBody Todo todo){
        todoService.deleteTodo(todo);
    }

    @GetMapping("/todo/{id}")
    public Todo getTodoById(@PathVariable Long id){
        return todoService.getTodoById(id);
    }
}
