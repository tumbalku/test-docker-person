package com.dockerapp.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/docker")
public class DockerController {

  @GetMapping
  public String getRes(){
    return "<h1>Hola test update coba</h1>";
  }
}
