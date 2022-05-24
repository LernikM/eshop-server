package com.mirzoyan.eshop.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.List;
import javax.validation.Valid;

import com.mirzoyan.eshop.domain.TransactionProduct;
import com.mirzoyan.eshop.dto.AllUserTransactionDto;
import com.mirzoyan.eshop.dto.TransactionDto;
import com.mirzoyan.eshop.service.ProductService;
import com.mirzoyan.eshop.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
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
    private final ProductService productService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<TransactionDto> create(@Valid @RequestBody final List<String> productsList) {
        return ok(transactionService.create(productsList.stream()
            .map(it -> modelMapper.map(productService.get(it), TransactionProduct.class))
            .toList()));
    }

    @GetMapping
    public ResponseEntity<List<AllUserTransactionDto>> getAll() {
        return ok(transactionService.findAllByUserId());
    }

}
