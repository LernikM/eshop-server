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
public class TransactionProductDto {
    @JsonIgnore
    Integer id;
    String hsCode;
    Integer amount;
    String calorie;
    String country;
    LocalDate validFrom;
    LocalDate validTo;
    String name;
    String description;
    String companyName;
    int count;
}
