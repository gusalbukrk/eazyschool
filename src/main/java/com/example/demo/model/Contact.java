package com.example.demo.model;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

// getters and setters are mandatory
// otherwise you will get null when trying to access the properties
@Data
public class Contact {
  @Length(message = "Name length must be >= 3 and <= 10.", min = 3, max = 10)
  public String name;

  @NotEmpty(message = "Email cannot be empty.")
  @Email(message = "Email must be valid.")
  public String email;
}
