package com.example.todorestapi.repositories;

import com.example.todorestapi.entities.Todo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class TodoRepositoryTests {
    @Autowired
    TodoRepository todoRepository;

    @Test
    public void exists(){
        assertNotNull(todoRepository);
    }

    @Test
    public void save(){
        todoRepository.save(new Todo("mail letter"));
    }
}
