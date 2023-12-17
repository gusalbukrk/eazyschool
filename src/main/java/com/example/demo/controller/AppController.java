package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Contact;
import com.example.demo.model.Holiday;

import jakarta.validation.Valid;

@Controller
public class AppController {
  @RequestMapping({ "/", "/home" })
  public String displayHomePage(Model model) {
    model.addAttribute("username", "John");
    return "home";
  }

  @GetMapping("/contact")
  public String displayContactPage(Model model) {
    model.addAttribute("contact", new Contact());
    return "contact";
  }

  // without model
  // @PostMapping("/save-contact")
  // public String saveContact(@RequestParam("fname") String fname,
  // @RequestParam("lname") String lname) {
  // System.out.println("Saving contact: " + fname + " " + lname);
  // return "redirect:/contact";
  // }

  @PostMapping("/save-contact")
  public String saveContact(@Valid @ModelAttribute Contact contact, Errors errors) {
    if (errors.hasErrors()) {
      System.out.println(errors.toString());
      return "contact.html";
    }

    System.out.println("Saving contact: " + contact.name + " " + contact.email);
    return "redirect:/contact";
  }

  @GetMapping({ "/holidays", "/holidays/{type}" }) // both are need because variable is optional
  public String displayHolidaysPage(@PathVariable(required = false /* defaults to true */) String type, Model model) {
    List<Holiday> holidays = Arrays.asList(
        new Holiday("Jan 01", "New Year's Day", Holiday.Type.FESTIVAL),
        new Holiday("Oct 31", "Halloween", Holiday.Type.FESTIVAL),
        new Holiday("July 4", "Independency Day", Holiday.Type.FEDERAL),
        new Holiday("Sep 5", "Labor Day", Holiday.Type.FEDERAL));

    model.addAttribute("type", type);
    model.addAttribute("holidays", holidays);
    return "holidays";
  }
}
