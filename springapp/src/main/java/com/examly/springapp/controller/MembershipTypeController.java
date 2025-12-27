package com.examly.springapp.controller;

import com.examly.springapp.model.MembershipType;
import com.examly.springapp.service.MembershipTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/membership-types")
public class MembershipTypeController {

  private final MembershipTypeService service;

  public MembershipTypeController(MembershipTypeService service) {
    this.service = service;
  }

  // TEST 48
  @PostMapping
  public ResponseEntity<MembershipType> create(@RequestBody MembershipType type) {
    return new ResponseEntity<>(service.create(type), HttpStatus.CREATED);
  }

  // TEST 49
  @PutMapping("/{id}")
  public ResponseEntity<MembershipType> update(
      @PathVariable Long id,
      @RequestBody MembershipType type) {
    return ResponseEntity.ok(service.update(id, type));
  }

  // TEST 50
  @GetMapping
  public ResponseEntity<List<MembershipType>> getAll() {
    return ResponseEntity.ok(service.getAll());
  }

  // TEST 51
  @GetMapping("/{id}")
  public ResponseEntity<MembershipType> getById(@PathVariable Long id) {
    return service.getById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  // TEST 52 & Day-12 (empty handling)
  @GetMapping("/name/{name}")
  public ResponseEntity<?> getByName(@PathVariable String name) {
    List<MembershipType> list = service.getByName(name);
    if (list.isEmpty()) {
      return ResponseEntity
          .status(HttpStatus.NO_CONTENT)
          .body("No membership types found");
    }
    return ResponseEntity.ok(list);
  }

  // TEST 53
  @GetMapping("/price")
  public ResponseEntity<List<MembershipType>> getByPriceRange(
      @RequestParam double min,
      @RequestParam double max) {
    return ResponseEntity.ok(service.getByPriceRange(min, max));
  }

  // TEST 54 & Day-12
  @GetMapping("/duration-greater/{duration}")
  public ResponseEntity<?> getByDuration(
      @PathVariable int duration) {

    List<MembershipType> list = service.getByDurationGreater(duration);
    if (list.isEmpty()) {
      return ResponseEntity
          .status(HttpStatus.NO_CONTENT)
          .body("No membership types found with duration greater than " + duration);
    }
    return ResponseEntity.ok(list);
  }
  // TEST 55 & Day-12
  @GetMapping("/price-less/{price}")
  public ResponseEntity<?> getByPriceLess(
      @PathVariable double price) {

    List<MembershipType> list = service.getByPriceLess(price);
    if (list.isEmpty()) {
      return ResponseEntity
          .status(HttpStatus.NO_CONTENT)
          .body("No membership types found");
    }
    return ResponseEntity.ok(list);
  }
}




