package com.mirzoyan.eshop.dto;

import java.util.ArrayList;
import java.util.List;

import com.mirzoyan.eshop.domain.TransactionProduct;
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
    private List<TransactionProduct> productList = new ArrayList<>();
}
