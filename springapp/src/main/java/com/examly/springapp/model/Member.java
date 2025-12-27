package com.examly.springapp.model;

import jakarta.persistence.*;

@Entity
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String email;

  // ✅ REQUIRED NO-ARG CONSTRUCTOR
  public Member() {
  }

  // (optional but safe)
  public Member(String name, String email) {
    this.name = name;
    this.email = email;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Member(Long id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }
}

