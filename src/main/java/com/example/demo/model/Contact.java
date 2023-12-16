package com.example.demo.model;

import lombok.Data;

// getters and setters are mandatory
// otherwise you will get null when trying to access the properties
@Data
public class Contact {
  public String fname;
  public String lname;
}
