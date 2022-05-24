package com.mirzoyan.eshop.dto;

import java.util.ArrayList;
import java.util.List;

import com.mirzoyan.eshop.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponseDto {

    Integer totalAmount;
    Integer totalCalorie;
    Integer totalMass;
    private List<Product> productList = new ArrayList<>();
}
