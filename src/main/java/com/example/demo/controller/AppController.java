package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Contact;
import com.example.demo.model.Holiday;

@Controller
public class AppController {
  @RequestMapping({ "/", "/home" })
  public String displayHomePage(Model model) {
    model.addAttribute("username", "John");
    return "home";
  }

  @GetMapping("/contact")
  public String displayContactPage() {
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
  public String saveContact(@ModelAttribute Contact contact) {
    System.out.println("Saving contact: " + contact.fname + " " + contact.lname);
    return "redirect:/contact";
  }

  @GetMapping("/holidays")
  public String displayHolidaysPage(Model model) {
    List<Holiday> holidays = Arrays.asList(
        new Holiday("Jan 01", "New Year's Day", Holiday.Type.FESTIVAL),
        new Holiday("Oct 31", "Halloween", Holiday.Type.FESTIVAL),
        new Holiday("July 4", "Independency Day", Holiday.Type.FEDERAL),
        new Holiday("Sep 5", "Labor Day", Holiday.Type.FEDERAL));

    model.addAttribute("holidays", holidays);
    return "holidays";
  }
}
