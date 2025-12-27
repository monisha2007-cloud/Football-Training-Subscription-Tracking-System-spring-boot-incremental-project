package com.examly.springapp.service;

import com.examly.springapp.model.MembershipType;

import java.util.List;
import java.util.Optional;

public interface MembershipTypeService {

  MembershipType create(MembershipType type);

  MembershipType update(Long id, MembershipType type);

  List<MembershipType> getAll();

  Optional<MembershipType> getById(Long id);

  List<MembershipType> getByName(String name);

  List<MembershipType> getByPriceRange(double min, double max);

  List<MembershipType> getByDurationGreater(int duration);

  List<MembershipType> getByPriceLess(double price);
}

