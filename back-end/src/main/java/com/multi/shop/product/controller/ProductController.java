package com.multi.shop.product.controller;

import com.multi.shop.product.dto.response.ProductsResponse;
import com.multi.shop.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ProductController {
    private final ProductService productService;

    @GetMapping("/api/product")
    public ResponseEntity<List<ProductsResponse>> getProducts(@Param("search") String search) {
        List<ProductsResponse> products = productService.getProducts(search);
        return ResponseEntity.ok(products);
    }
}


