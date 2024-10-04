package com.dockerapp.demo.service;

import com.dockerapp.demo.DataConvertTo;
import com.dockerapp.demo.entity.Person;
import com.dockerapp.demo.model.PersonRequest;
import com.dockerapp.demo.model.PersonResponse;
import com.dockerapp.demo.model.PersonUpdate;
import com.dockerapp.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

  private final PersonRepository personRepository;

  @Autowired
  public PersonServiceImpl(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  Person getPerson(Integer id) {
    return personRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found!"));
  }

  @Override
  public PersonResponse getPersonById(Integer id) {
    return DataConvertTo.personResponse(getPerson(id));
  }

  @Override
  public List<PersonResponse> getPeople() {
    return personRepository.findAll().stream()
            .map(DataConvertTo::personResponse)
            .collect(Collectors.toList());
  }

  @Override
  public String createPerson(PersonRequest request) {
    Person person = new Person();
    person.setAge(request.getAge());
    person.setName(request.getName());
    person.setUsername(request.getUsername());
    person.setPassword(request.getUsername());
    personRepository.save(person);
    return "Success create new person";
  }

  @Override
  public String updatePerson(PersonUpdate request) {
    Person person = getPerson(request.getId());
    person.setAge(request.getAge());
    person.setName(request.getName());
    personRepository.save(person);
    return "Success update person";
  }

  @Override
  public String deletePerson(Integer id) {
    Person person = getPerson(id);
    personRepository.delete(person);
    return "Success delete person";
  }
}
