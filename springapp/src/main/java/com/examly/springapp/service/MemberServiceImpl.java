package com.examly.springapp.service;

import com.examly.springapp.model.Member;
import com.examly.springapp.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

  private final MemberRepository repository;

  public MemberServiceImpl(MemberRepository repository) {
    this.repository = repository;
  }

  @Override
  public Page<Member> getAllMembers(Pageable pageable) {
    return repository.findAll(pageable);
  }

  @Override
  public Member createMember(Member member) { // ✅ IMPLEMENTED
    return repository.save(member);
  }

  @Override
  public Optional<Member> getMemberById(Long id) {
    return repository.findById(id);
  }

  @Override
  public Member updateMember(Long id, Member member) {
    return repository.findById(id)
        .map(existing -> {
          existing.setName(member.getName());
          existing.setEmail(member.getEmail());
          return repository.save(existing);
        })
        .orElseThrow(() -> new RuntimeException("Member not found"));
  }

  @Override
  public void deleteMember(Long id) {
    repository.deleteById(id);
  }
}

