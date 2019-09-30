package com.example.todorestapi.entities;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TodoTests {

    @Test
    public void exists(){
        assertNotNull(new Todo());
    }

    @Test
    public void message(){
        Todo todo = new Todo("take out trash");
        assertEquals("take out trash", todo.getMessage());
    }
}
