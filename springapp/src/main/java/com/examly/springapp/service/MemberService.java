package com.examly.springapp.service;

import com.examly.springapp.model.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface MemberService {

  Page<Member> getAllMembers(Pageable pageable);

  Member createMember(Member member); // ✅ REQUIRED

  Optional<Member> getMemberById(Long id);

  Member updateMember(Long id, Member member);

  void deleteMember(Long id);
}

