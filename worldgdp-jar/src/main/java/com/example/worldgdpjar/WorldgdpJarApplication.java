package com.example.worldgdpjar;

import com.example.worldgdpjar.dao.CountryService;
import com.example.worldgdpjar.model.Country;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@MapperScan("com.example.worldgdpjar.dao")
@SpringBootApplication
public class WorldgdpJarApplication {

  public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(WorldgdpJarApplication.class, args);
    /*
       CountryDAO dao = context.getBean(CountryDAO.class);
       List<String> cs = dao.getContinents();
       cs.sort(String.CASE_INSENSITIVE_ORDER);
       cs.forEach(System.out::println);

       List<String> gs = dao.getGovernmentTypes();
       gs.forEach(System.out::println);
    */

    CountryService service = context.getBean(CountryService.class);
    Map<String, Object> params = new HashMap<>();
    params.put("search", "ch");

    List<Country> countryList = service.getCountries(params);
    countryList.forEach(System.out::println);

    //    Country country = service.getCountryDetails("CHN");
    //    System.out.println(country);
  }
}
