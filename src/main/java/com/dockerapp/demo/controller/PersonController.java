package com.dockerapp.demo.controller;

import com.dockerapp.demo.model.PersonRequest;
import com.dockerapp.demo.model.PersonResponse;
import com.dockerapp.demo.model.PersonUpdate;
import com.dockerapp.demo.service.PersonService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/person")
public class PersonController {

  private final PersonService service;

  @Autowired
  public PersonController(PersonService service) {
    this.service = service;
  }

  @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PersonResponse> getPersonById(@PathVariable("id") Integer id){
    PersonResponse response = service.getPersonById(id);
    return ResponseEntity.status(200).body(response);
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<PersonResponse>> getPeople(){
    return ResponseEntity.status(200).body(service.getPeople());
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> createPerson(@RequestBody PersonRequest request){
    String response = service.createPerson(request);
    return ResponseEntity.status(201).body(response);
  }

  @PutMapping(path= "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> updatePerson(@PathVariable("id") Integer id, @RequestBody PersonUpdate request){
    request.setId(id);
    String response = service.updatePerson(request);
    return ResponseEntity.status(201).body(response);
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<String> deletePerson(@PathVariable("id") Integer id){
    String response = service.deletePerson(id);
    return ResponseEntity.status(200).body(response);
  }
}
