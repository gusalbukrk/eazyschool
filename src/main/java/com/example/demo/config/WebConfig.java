package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
  @Override
  public void addViewControllers(org.springframework.web.servlet.config.annotation.ViewControllerRegistry registry) {
    registry.addViewController("/about").setViewName("about");
  }
}
