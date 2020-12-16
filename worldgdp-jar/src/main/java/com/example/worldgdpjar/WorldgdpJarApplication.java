package com.example.worldgdpjar;

import com.example.worldgdpjar.dao.CountryDao;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@MapperScan("com.example.worldgdpjar.dao")
@SpringBootApplication
public class WorldgdpJarApplication {

  public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(WorldgdpJarApplication.class, args);

    CountryDao dao = context.getBean(CountryDao.class);
    List<String> cs = dao.getContinents();
    cs.sort(String.CASE_INSENSITIVE_ORDER);
    cs.forEach(System.out::println);

    List<String> gs = dao.getGovernmentTypes();
    gs.forEach(System.out::println);
  }
}
