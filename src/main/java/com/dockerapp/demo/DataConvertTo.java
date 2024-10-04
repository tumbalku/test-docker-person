package com.dockerapp.demo;

import com.dockerapp.demo.entity.Person;
import com.dockerapp.demo.model.PersonResponse;
import org.springframework.stereotype.Service;

@Service
public class DataConvertTo {

  public static PersonResponse personResponse(Person person){
    PersonResponse response = new PersonResponse();
    response.setId(person.getId());
    response.setAge(person.getAge());
    response.setName(person.getName());
    return response;
  }
}
