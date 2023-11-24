package org.search.contextualSearch.controller;

import org.search.contextualSearch.model.Person;
import org.search.contextualSearch.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/person/{name}")
    public ResponseEntity<Person> getPerson(@PathVariable String name) {
        Person person = personService.findByName(name);
        if (Objects.isNull(person))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping("/person")
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        if (person.getAge() >= 18) {
            personService.addPerson(person);
            return new ResponseEntity<>(person, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
