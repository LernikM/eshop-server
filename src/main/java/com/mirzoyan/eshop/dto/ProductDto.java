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
    String hsCode;
    String name;
    String calorie;
    String country;
    LocalDate validFrom;
    LocalDate validTo;
    String companyName;
    String typeOfProduct;
}
