package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import com.example.demo.model.Contact;

@Service // by default, @Service uses singleton scope
@RequestScope // ContactService will be created and counter reset for each request
// @SessionScope // ContactService will be created and counter reset for each
// new browser session
// @ApplicationScope // ContactService will be created only once
public class ContactService {
  private int counter = 0;

  public ContactService() {
    System.out.println("ContactService created.");
  }

  public String saveContact(Contact contact) {
    System.out.println(++counter + " - Saving contact: " + contact.name + " " + contact.email);
    return "redirect:/contact";
  }
}
