package org.search.contextualSearch.service;

import org.search.contextualSearch.model.Person;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PersonService {

    private final Map<String, Person> personMap = new HashMap<>();

    public void addPerson(Person person){
        personMap.put(person.getName(), person);
    }

    public Person getPerson(String name){
        return personMap.get(name);
    }
}
