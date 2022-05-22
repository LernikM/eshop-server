package com.mirzoyan.eshop.controller;

import static java.util.Objects.nonNull;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

import javax.validation.Valid;

import com.mirzoyan.eshop.domain.Product;
import com.mirzoyan.eshop.dto.ProductDto;
import com.mirzoyan.eshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("product")
@Validated
public class ProductController {
    private final ProductService productService;
    private final ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable(value = "id") Long id) {
        return ok(modelMapper.map(productService.get(id), ProductDto.class));
    }

    @GetMapping("/getByHsCode/{hsCode}")
    public ResponseEntity<ProductDto> getByHsCode(@PathVariable(value = "hsCode") String hsCode) {
        Product product = productService.get(hsCode);
        return nonNull(product) ? ok(modelMapper.map(product, ProductDto.class)) : notFound().build();
    }

    @PostMapping
    public ResponseEntity<ProductDto> create(@Valid @RequestBody final ProductDto request) {

        ProductDto productResponse = productService.create(request);
        log.debug("Done Create exim, id - {}", productResponse.getId());
        return ok(productResponse);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ProductDto> update(@PathVariable("id") final Long id, @Valid @RequestBody final ProductDto request) {
        ProductDto productResponse = productService.update(id, request);
        log.debug("Done updating exim, id - {}", productResponse.getId());
        return ok(productResponse);
    }

}
