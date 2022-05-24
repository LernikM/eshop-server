package com.mirzoyan.eshop.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AllUserTransactionDto {

    private LocalDateTime transactionDate;
    private TransactionResponseDto transactionResponseDto;
}
