package com.mirzoyan.eshop.service;

import java.time.LocalDateTime;
import java.util.List;

import com.mirzoyan.eshop.domain.Transaction;
import com.mirzoyan.eshop.domain.TransactionProduct;
import com.mirzoyan.eshop.dto.AllUserTransactionDto;
import com.mirzoyan.eshop.dto.TransactionDto;
import com.mirzoyan.eshop.dto.TransactionResponseDto;
import com.mirzoyan.eshop.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class TransactionService {

    private final ModelMapper modelMapper;
    private final TransactionRepository transactionRepository;
    private final UserDetailsService userDetailsService;

    public List<AllUserTransactionDto> findAllByUserId() {
        return transactionRepository.findAllByUserId(userDetailsService.getUserId()).stream()
            .map(transaction -> new AllUserTransactionDto(transaction.getTransactionDate(), mapTransactionResponse(transaction)))
            .toList();
    }

    /**
     * Try to Save transaction.
     *
     * @param transactionDto TransactionCreateDto
     * @return {@link TransactionDto}
     */
    @Transactional
    public TransactionDto create(TransactionDto transactionDto) {

        Transaction transaction = modelMapper.map(transactionDto, Transaction.class);
        transaction.setUserId(userDetailsService.getUserId());
        transaction.setTotalAmount(transaction.getProductList().stream().mapToInt(TransactionProduct::getAmount).sum());
        transaction.setTotalCalorie(transaction.getProductList().stream().mapToInt(TransactionProduct::getCalorie).sum());
        transaction.setTotalMass(transaction.getProductList().stream().mapToInt(TransactionProduct::getMass).sum());
        transaction.setTransactionDate(LocalDateTime.now());
        transactionRepository.save(transaction);
        return modelMapper.map(transaction, TransactionDto.class);
    }

    public TransactionResponseDto mapTransactionResponse(Transaction transaction) {
        return modelMapper.map(transaction, TransactionResponseDto.class);
    }
}
