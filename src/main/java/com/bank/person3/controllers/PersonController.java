package com.bank.person3.controllers;

import com.bank.person3.models.documents.Person;
import com.bank.person3.repository.impl.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    private PersonRepository personRepository;

    public PersonController(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @GetMapping
    public Map<String, Person> findAll(){
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable String id){
        return personRepository.findById(id);
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person){
        return personRepository.save(person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable String id){
        personRepository.delete(id);
    }
}
