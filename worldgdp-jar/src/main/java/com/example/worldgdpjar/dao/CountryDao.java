package com.example.worldgdpjar.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryDao {
  public List<String> getContinents();

  public List<String> getRegions();

  public List<String> getHeadOfStates();

  public List<String> getGovernmentTypes();
}
