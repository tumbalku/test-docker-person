package com.dockerapp.demo.model;

public class LoginRequest {

  private String username;

  private String password;

  public String getUsername() {
    return username;
  }

  public LoginRequest(){}
  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
