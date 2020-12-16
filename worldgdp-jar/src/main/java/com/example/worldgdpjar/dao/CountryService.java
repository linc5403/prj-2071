package com.example.worldgdpjar.dao;

import com.example.worldgdpjar.model.Country;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CountryService {
  private final CountryDAO countryDAO;

  private Map<String, String> paraParse(Map<String, Object> params) {
    Map<String, String> rlt = new HashMap<>();
    String search = params.containsKey("search") ? params.get("search").toString() : null;

    String continent = params.containsKey("continent") ? params.get("continent").toString() : null;

    String region = params.containsKey("region") ? params.get("region").toString() : null;
    rlt.put("search", search);
    rlt.put("continent", continent);
    rlt.put("region", region);
    return rlt;
  }

  public CountryService(CountryDAO countryDAO) {
    this.countryDAO = countryDAO;
  }

  public List<Country> getCountries(Map<String, Object> params) {

    // 得到了offset和size
    int pageNo = 1;
    if (params.containsKey("pageNo")) {
      pageNo = Integer.parseInt(params.get("pageNo").toString());
    }

    Integer PAGE_SIZE = 20;
    Integer offset = (pageNo - 1) * PAGE_SIZE;
    Map<String, String> map = paraParse(params);
    String search = map.get("search");
    String continent = map.get("continent");
    String region = map.get("region");
    //    String code = params.containsKey("code") ? params.get("code").toString() : null;

    return countryDAO.getCountries(PAGE_SIZE, offset, search, continent, region);
  }

  public int getCountriesCount(Map<String, Object> params) {
    Map<String, String> map = paraParse(params);
    String search = map.get("search");
    String continent = map.get("continent");
    String region = map.get("region");
    return countryDAO.getCountriesCount(search, continent, region);
  }
}
