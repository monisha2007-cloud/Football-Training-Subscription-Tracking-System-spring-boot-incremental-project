package com.examly.springapp.repository;

import com.examly.springapp.model.MembershipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MembershipTypeRepository extends JpaRepository<MembershipType, Long> {
  @Query("SELECT m FROM MembershipType m WHERE m.typeName = ?1")
  List<MembershipType> findByTypeNameJPQL(String name);
  List<MembershipType> findByPriceBetween(double min, double max);
  List<MembershipType> findByDurationInMonthsGreaterThan(int duration);
  List<MembershipType> findByPriceLessThan(double price);
}

