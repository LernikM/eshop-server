package com.mirzoyan.eshop.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    String hsCode;
    String name;
    String description;
    String companyName;
    Integer calorie;
    Integer mass;
    Integer amount;
    String country;
    LocalDate validFrom;
    LocalDate validTo;
}
