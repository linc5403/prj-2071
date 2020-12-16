package com.example.worldgdpjar.controller;

import com.example.worldgdpjar.dao.CountryDAO;
import com.example.worldgdpjar.dao.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/")
public class ViewController {
  private final CountryService countryService;
  private final CountryDAO countryDAO;

  public ViewController(CountryService countryService, CountryDAO countryDAO) {
    this.countryService = countryService;
    this.countryDAO = countryDAO;
  }

  @GetMapping({"/countries", "/"})
  public String countries(Model model, @RequestParam Map<String, Object> params) {

    model.addAttribute("continents", countryDAO.getContinents());
    model.addAttribute("regions", countryDAO.getRegions());
    model.addAttribute("countries", countryService.getCountries(params));
    model.addAttribute("count", countryService.getCountriesCount(params));

    return "countries";
  }

  @GetMapping("/countries/{code}")
  public String countryDetail(@PathVariable String code, Model model) {
    model.addAttribute("c", countryDAO.getCountryDetails(code));
    return "country";
  }

  @GetMapping("/countries/{code}/form")
  public String editCountry(@PathVariable String code, Model model) {
    model.addAttribute("c", countryDAO.getCountryDetails(code));
    /*
    model.addAttribute("cities", cityDao.getCities(code));
    model.addAttribute("continents", lookupDao.getContinents());
    model.addAttribute("regions", lookupDao.getRegions());
    model.addAttribute("heads", lookupDao.getHeadOfStates());
    model.addAttribute("govs", lookupDao.getGovernmentTypes());
     */
    return "country-form";
  }
}
