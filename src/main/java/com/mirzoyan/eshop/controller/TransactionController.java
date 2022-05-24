package com.mirzoyan.eshop.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.List;
import javax.validation.Valid;

import com.mirzoyan.eshop.domain.Transaction;
import com.mirzoyan.eshop.dto.AllUserTransactionDto;
import com.mirzoyan.eshop.dto.TransactionDto;
import com.mirzoyan.eshop.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("transaction")
@Validated
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<TransactionDto> create(@Valid @RequestBody final TransactionDto request) {
        return ok(transactionService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<AllUserTransactionDto>> getAll() {
        return ok(transactionService.findAllByUserId());
    }

}
