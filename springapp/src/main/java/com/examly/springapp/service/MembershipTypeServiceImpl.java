package com.examly.springapp.service;

import com.examly.springapp.model.MembershipType;
import com.examly.springapp.repository.MembershipTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembershipTypeServiceImpl implements MembershipTypeService {

  private final MembershipTypeRepository repository;

  public MembershipTypeServiceImpl(MembershipTypeRepository repository) {
    this.repository = repository;
  }

  @Override
  public MembershipType create(MembershipType type) {
    return repository.save(type);
  }

  @Override
  public MembershipType update(Long id, MembershipType type) {
    MembershipType existing = repository.findById(id).orElseThrow();
    existing.setTypeName(type.getTypeName());
    existing.setPrice(type.getPrice());
    existing.setDurationInMonths(type.getDurationInMonths());
    return repository.save(existing);
  }

  @Override
  public List<MembershipType> getAll() {
    return repository.findAll();
  }

  @Override
  public Optional<MembershipType> getById(Long id) {
    return repository.findById(id);
  }

  @Override
  public List<MembershipType> getByName(String name) {
    return repository.findByTypeNameJPQL(name);
  }

  @Override
  public List<MembershipType> getByPriceRange(double min, double max) {
    return repository.findByPriceBetween(min, max);
  }

  @Override
  public List<MembershipType> getByDurationGreater(int duration) {
    return repository.findByDurationInMonthsGreaterThan(duration);
  }

  @Override
  public List<MembershipType> getByPriceLess(double price) {
    return repository.findByPriceLessThan(price);
  }
}

