package com.multi.shop.product.controller;

import com.multi.shop.product.dto.request.ProductRequest;
import com.multi.shop.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ProductController {
    private final ProductService productService;

    @PostMapping("/api/product")
    public ResponseEntity<Void> getProduct(@RequestBody @Valid ProductRequest request) {
        productService.getProduct(request);
        return ResponseEntity.ok().build();
    }
}

