package com.multi.shop.product.repository;

import com.multi.shop.product.dto.ProductDTO;
import com.multi.shop.product.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ProductRepository {
    private final ProductMapper productMapper;

    public Long getProduct(ProductDTO dto) {
        return productMapper.selectListProduct(dto);
    }
}
