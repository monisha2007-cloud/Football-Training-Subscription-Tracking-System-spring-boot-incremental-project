package com.examly.springapp.model;
import jakarta.persistence.*;
@Entity

public class Payment {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;

  public int getId() {
    return id;
  }

  public Payment(int id) {
    this.id = id;
  }

  public void setId(int id) {
    this.id = id;
  }

  
  

}

