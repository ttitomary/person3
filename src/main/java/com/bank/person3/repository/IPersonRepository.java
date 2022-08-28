package com.bank.person3.repository;

import com.bank.person3.models.documents.Person;

import java.util.Map;

public interface IPersonRepository {
    Map<String, Person> findAll();
    Person findById(String id);
    Person save(Person person);
    void delete(String id);
}
