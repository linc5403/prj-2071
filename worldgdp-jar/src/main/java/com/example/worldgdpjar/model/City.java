package com.example.worldgdpjar.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class City {

  private Long id;

  @NotNull
  @Size(max = 35)
  private String name;

  @NotNull
  @Size(max = 3, min = 3)
  private String countryCode;

  private Country country;

  @NotNull
  @Size(max = 20)
  private String district;

  @NotNull private Long population;
}
