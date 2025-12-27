package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Attendance;

@RestController
@RequestMapping("/api/attendance") // REQUIRED
public class AttendanceController {

  @GetMapping("/{id}")      // any HTTP mapping is fine
  public Attendance getAttendance(@PathVariable Long id) { // REQUIRED
    return null;
  }
}

