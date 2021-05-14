package com.example.service;

import com.example.MainApp;
import com.example.model.People;
import com.example.repository.PeopleRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = MainApp.class)
class PeopleServiceTest {
    @Autowired
    PeopleRepository repository;
    People people1;
    People people2;

    @BeforeEach
    void beforeEach(){
        people1 = new People(1L,"Vova1");
        people2 = new People(2L, "Voloda2");
        repository.save(people1);
        repository.save(people2);
    }
    @AfterEach
    void afterEach(){
        repository.deleteAll();
    }
    @Test
    void findById_Test() throws Exception{
        assertEquals(1,repository.findById(1L).get().getId());
        assertEquals("Vova1",repository.findById(1L).get().getName());
    }
}