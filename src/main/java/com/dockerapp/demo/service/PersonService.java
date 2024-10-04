package com.dockerapp.demo.service;

import com.dockerapp.demo.model.PersonRequest;
import com.dockerapp.demo.model.PersonResponse;
import com.dockerapp.demo.model.PersonUpdate;

import java.util.List;

public interface PersonService {

  PersonResponse getPersonById(Integer id);
  List<PersonResponse> getPeople();

  String createPerson(PersonRequest request);
  String updatePerson(PersonUpdate request);

  String deletePerson(Integer id);


}
