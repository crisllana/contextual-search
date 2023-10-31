package org.search.contextualSearch.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.search.contextualSearch.model.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @InjectMocks
    private PersonService personService;

    @Test
    void testService() {
        Person person = new Person("Pepe", "Garcia", 22);
        personService.addPerson(person);

        assertEquals(person, personService.getPerson("Pepe"));
    }
}