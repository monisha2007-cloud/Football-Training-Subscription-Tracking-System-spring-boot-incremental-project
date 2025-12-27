package com.examly.springapp.controller;

import com.examly.springapp.model.Member;
import com.examly.springapp.service.MemberService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

  private final MemberService service;

  public MemberController(MemberService service) {
    this.service = service;
  }

  // Pagination (not used in Day-10 tests but kept)
  @GetMapping("/page/{page}/{size}")
  public List<Member> getMembersWithPagination(
      @PathVariable int page,
      @PathVariable int size) {

    Page<Member> memberPage =
        service.getAllMembers(PageRequest.of(page, size));
    return memberPage.getContent();
  }

  // ✅ CREATE MEMBER → returns 201 CREATED
  @PostMapping
  public ResponseEntity<Member> create(@RequestBody Member member) {
    Member saved = service.createMember(member);
    return new ResponseEntity<>(saved, HttpStatus.CREATED);
  }

  // ✅ GET MEMBER BY ID → returns 200 OK
  @GetMapping("/{id}")
  public ResponseEntity<Member> getById(@PathVariable Long id) {
    return service.getMemberById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  // ✅ UPDATE MEMBER → returns 200 OK
  @PutMapping("/{id}")
  public ResponseEntity<Member> update(
      @PathVariable Long id,
      @RequestBody Member member) {

    Member updated = service.updateMember(id, member);
    return ResponseEntity.ok(updated);
  }
}

