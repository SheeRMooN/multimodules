package com.example.service;

import com.example.model.People;
import com.example.repository.PeopleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PeopleService {
    PeopleRepository repository;

    public Optional<People> findById(Long id){
        return repository.findById(id);
    }
    public List<People> findAll(){
        return repository.findAll();
    }
    public void delete(Long id){
        People people = new People();
        people.setId(id);
        repository.delete(people);
    }
    public People save(People people){
        return repository.save(people);
    }
}
