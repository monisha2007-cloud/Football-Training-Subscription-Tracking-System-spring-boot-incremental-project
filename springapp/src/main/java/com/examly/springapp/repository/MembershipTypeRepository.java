package com.examly.springapp.repository;

import com.examly.springapp.model.MembershipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MembershipTypeRepository extends JpaRepository<MembershipType, Long> {

  // JPQL query (TEST 52)
  @Query("SELECT m FROM MembershipType m WHERE m.typeName = ?1")
  List<MembershipType> findByTypeNameJPQL(String name);

  // TEST 53
  List<MembershipType> findByPriceBetween(double min, double max);

  // TEST 54
  List<MembershipType> findByDurationInMonthsGreaterThan(int duration);

  // TEST 55
  List<MembershipType> findByPriceLessThan(double price);
}

