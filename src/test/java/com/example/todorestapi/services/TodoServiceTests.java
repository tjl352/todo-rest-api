package com.example.todorestapi.services;

import com.example.todorestapi.entities.Todo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TodoServiceTests {

    @Autowired
    TodoService todoService;

    private Todo todo;

    @Before
    public void setup(){
        todo = new Todo("walk dog");
    }

    @Test
    public void exists(){
        assertNotNull(todoService);
    }

    @Test
    public void addTodo(){
        assertEquals("walk dog", todoService.addTodo(todo).getMessage());
    }

    @Test
    public void getTodoId(){
        todoService.addTodo(todo).getMessage();
        assertEquals("walk dog", todoService.getTodoById(todo.getId()).getMessage());
    }

    @Test
    public void updateTodo(){
        todoService.addTodo(todo).getMessage();
        Todo updateTodo = new Todo("wash car");
        assertEquals("wash car", todoService.updateTodo(updateTodo).getMessage());
    }

    @Test(expected = NoSuchElementException.class)
    public void deleteTodo(){
        todoService.addTodo(todo).getMessage();
        todoService.deleteTodo(todo);
        todoService.getTodoById(todo.getId());
    }
}
