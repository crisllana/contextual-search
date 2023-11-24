package org.search.contextualSearch.service;

import org.search.contextualSearch.model.Person;
import org.search.contextualSearch.repository.ElasticPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private ElasticPersonRepository elasticPersonRepository;

    public void addPerson(Person person) {
        elasticPersonRepository.save(person);
    }

    public Person findByName(String name) {
        return elasticPersonRepository.findByName(name);
    }

}
