package com.example.repository;

import com.example.MainApp;
import com.example.model.People;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PeopleRepositoryTest {
    @Autowired
    PeopleRepository repository;
    People people1;
    People people2;

    @BeforeEach
    void beforeEach(){
        people1 = repository.save(new People(1L,"Vova1"));
        people2 = repository.save(new People(2L,"Vova2"));
    }
    @AfterEach
    void afterEach(){
        repository.deleteAll();
    }
    @Test
    void findById_Test() throws Exception{
        assertEquals(people1,repository.findById(1L).get());
    }
    @Test
    void findAll_Test() throws Exception{
        assertEquals(2,repository.findAll().size());
    }
    @Test
    void delete_Test() throws Exception{
        repository.delete(people1);
        assertEquals(1,repository.findAll().size());
    }
}