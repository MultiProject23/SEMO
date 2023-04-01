package com.multi.shop.product.repository;

import com.multi.shop.product.domain.dao.ProductDAO;
import com.multi.shop.product.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class ProductRepository {
    private final ProductMapper productMapper;

    public Long getProduct(ProductDAO dao) {
        return productMapper.selectListProduct(dao);
    }
}
