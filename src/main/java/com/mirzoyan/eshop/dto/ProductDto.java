package com.mirzoyan.eshop.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    @JsonIgnore
    private Integer id;
    String name;
    String description;
    String companyName;
    Integer calorie;
    Integer mass;
    Integer amount;
    String country;
    LocalDate validFrom;
    LocalDate validTo;
    Integer type;
}
