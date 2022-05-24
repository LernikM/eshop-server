package com.mirzoyan.eshop.config;

import com.mirzoyan.eshop.domain.Product;
import com.mirzoyan.eshop.domain.Transaction;
import com.mirzoyan.eshop.domain.TransactionProduct;
import com.mirzoyan.eshop.dto.ProductDto;
import com.mirzoyan.eshop.dto.TransactionDto;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappingConfig {

    @Bean
    public ModelMapper modelMapper() {
        var mapper = new ModelMapper();
        initMappingTransaction(mapper);
        initMappingProduct(mapper);
        return mapper;
    }

    public void initMappingTransaction(ModelMapper modelMapper) {
        modelMapper.createTypeMap(TransactionDto.class, Transaction.class)
            .addMappings(mapping -> mapping.skip(Transaction::setId));
        modelMapper.createTypeMap(Product.class, TransactionProduct.class)
            .addMappings(mapping -> mapping.skip(TransactionProduct::setId));
    }

    public void initMappingProduct(ModelMapper modelMapper) {
        modelMapper.createTypeMap(ProductDto.class, Product.class)
            .addMappings(mapping -> mapping.skip(Product::setId));
    }
}
