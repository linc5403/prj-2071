package com.example.worldgdpjar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

  @GetMapping({"/", "countries"})
  String indexPage() {
    return "countries";
  }
}
