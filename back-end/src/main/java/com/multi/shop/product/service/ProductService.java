package com.multi.shop.product.service;

import com.multi.shop.member.repository.MemberRepository;
import com.multi.shop.product.domain.dao.ProductDAO;
import com.multi.shop.product.dto.request.ProductRequest;
import com.multi.shop.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public Long getProduct(ProductRequest request) {
        ProductDAO dao = ProductDAO.builder()
                .target(request.getTarget())
                .category(request.getCategory())
                .build();

        return productRepository.getProduct(dao);
    }
}
