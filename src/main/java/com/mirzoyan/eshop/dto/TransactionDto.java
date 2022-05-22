package com.mirzoyan.eshop.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {

    @JsonIgnore
    private Integer id;
    LocalDate transactionDate;
    BigDecimal totalAmount;
    private List<TransactionProductDto> productList = new ArrayList<>();

//    @Valid
//    @OneToOne(cascade = ALL)
//    @JoinColumn(name = "user_id")
//    private User user;
}
