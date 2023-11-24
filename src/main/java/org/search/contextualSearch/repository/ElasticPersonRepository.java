package org.search.contextualSearch.repository;

import org.search.contextualSearch.model.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElasticPersonRepository extends ElasticsearchRepository<Person, String> {

    Person findByName(String name);

}
