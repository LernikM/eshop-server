package com.mirzoyan.eshop.repository;

import java.util.Optional;

import com.mirzoyan.eshop.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Optional<Product> findByHsCode(String hdCOde);
}
