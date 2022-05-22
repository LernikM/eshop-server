package com.mirzoyan.eshop.service;

import com.mirzoyan.eshop.domain.Product;
import com.mirzoyan.eshop.dto.ProductDto;
import com.mirzoyan.eshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;

    public Product get(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product get(String hsCode) {
        return productRepository.findByHsCode(hsCode).orElse(null);
    }

    @Transactional
    public ProductDto create(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        productRepository.save(product);
        return modelMapper.map(product, ProductDto.class);
    }

    @Transactional
    public ProductDto update(Long id, ProductDto productDto) {
        var oldProduct = productRepository.findById(id).orElse(new Product());
        modelMapper.map(productDto, oldProduct);
        productRepository.save(oldProduct);
        return modelMapper.map(oldProduct, ProductDto.class);
    }
}
