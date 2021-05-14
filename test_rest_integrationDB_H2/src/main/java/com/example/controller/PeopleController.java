package com.example.controller;

import com.example.model.People;
import com.example.service.PeopleService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/people")
@NoArgsConstructor
public class PeopleController {
    PeopleService service;

    @GetMapping("/all")
    public List<People> findAll(){
        return service.findAll();
    }
    @GetMapping("/get/{id}")
    public Optional<People> findById(@PathVariable Long id){
        return service.findById(id);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        service.delete(id);
        return "success delete "+ id;
    }
    @PostMapping("/update")
    public People create(@RequestBody People people){
        return service.save(people);
    }
}
