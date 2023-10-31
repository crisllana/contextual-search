package org.search.contextualSearch.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.search.contextualSearch.model.Person;
import org.search.contextualSearch.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonControllerTest {

    @Mock
    private PersonService personService;

    @InjectMocks
    private PersonController personController;

    @Test
    void testGetPerson() {
        Person person = new Person("Pepe", "Garcia", 22);

        when(personService.getPerson("Pepe")).thenReturn(new Person("Pepe", "Garcia", 22));

        ResponseEntity<Person> responseEntity = personController.getPerson("Pepe");

        assertEquals(person.getName(), responseEntity.getBody().getName());
        assertEquals(person.getAge(), responseEntity.getBody().getAge());
        assertEquals(person.getSurname(), responseEntity.getBody().getSurname());

    }

    @Test
    void testGetPersonNull() {
        when(personService.getPerson("Pepe")).thenReturn(null);
        ResponseEntity<Person> responseEntity = personController.getPerson("Pepe");

        assertNull(responseEntity.getBody());
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    void testAddPersonWhenAgeGreaterThan18() {
        Person person = new Person("Pepe", "Garcia", 22);

        ResponseEntity<Person> responseEntity = personController.addPerson(person);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        assertEquals(person.getName(), responseEntity.getBody().getName());
        assertEquals(person.getAge(), responseEntity.getBody().getAge());
        assertEquals(person.getSurname(), responseEntity.getBody().getSurname());

    }

    @Test
    void testAddPersonWhenAgeLowerThan18() {
        Person person = new Person("Pepe", "Garcia", 15);

        ResponseEntity<Person> responseEntity = personController.addPerson(person);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }
}