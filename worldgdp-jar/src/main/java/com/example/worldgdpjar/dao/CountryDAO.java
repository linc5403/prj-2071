package com.example.worldgdpjar.dao;

import com.example.worldgdpjar.model.Country;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryDAO {
  public List<String> getContinents();

  public List<String> getRegions();

  public List<String> getHeadOfStates();

  public List<String> getGovernmentTypes();

  public List<Country> getCountries(
      Integer size, Integer offset, String search, String continent, String region);

  public Country getCountryDetails(String code);

  public int getCountriesCount(String search, String continent, String region);
}
