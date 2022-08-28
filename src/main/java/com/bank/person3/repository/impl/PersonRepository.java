package com.bank.person3.repository.impl;

import com.bank.person3.models.documents.Person;
import com.bank.person3.repository.IPersonRepository;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Repository
public class PersonRepository implements IPersonRepository {
    private static final String KEY = "person";
    private RedisTemplate<String, Person> redisTemplate;
    private HashOperations hashOperations;

    public PersonRepository(RedisTemplate<String, Person> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init(){
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public Map<String, Person> findAll() {
        return hashOperations.entries(KEY);
    }

    @Override
    public Person findById(String id) {
        return (Person)hashOperations.get(KEY, id);
    }

    @Override
    public Person save(Person person) {
        person.setCreatedDate(LocalDateTime.now());
        hashOperations.put(KEY, UUID.randomUUID().toString(), person);
        return person;
    }

    @Override
    public void delete(String id) {
        hashOperations.delete(KEY, UUID.randomUUID().toString(), id);
    }
}
