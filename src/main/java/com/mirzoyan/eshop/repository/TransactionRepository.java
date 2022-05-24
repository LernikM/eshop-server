package com.mirzoyan.eshop.repository;

import java.util.List;

import com.mirzoyan.eshop.domain.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    List<Transaction> findAllByUserId(String userId);
}
