package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Membership;

@RestController
@RequestMapping("/api/memberships") // REQUIRED
public class MembershipController {

  @GetMapping("/{id}")
  public Membership getMembership(@PathVariable Long id) { // REQUIRED
    return null;
  }
}

