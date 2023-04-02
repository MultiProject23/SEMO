package com.multi.shop.product.service;

import com.multi.shop.product.domain.vo.ProductVO;
import com.multi.shop.product.dto.response.ProductsResponse;
import com.multi.shop.product.repository.ProductRepository;
import com.p6spy.engine.logging.Category;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public List<ProductsResponse> getProducts(String search) {
        List<ProductVO> products = productRepository.getProducts(search);
        List<ProductsResponse> responses = new ArrayList<>();

        for(ProductVO product : products) {
            //Category category = new Category(product.getCategory());
            //Target target = new Target(product.getTarget());

            responses.add(ProductsResponse.builder()
                    .id(product.getId())
                    .image(product.getImage())
                    .name(product.getName())
                    .price(product.getPrice())
                   // .category(category)
                    .category(product.getCategory())
                    .target(product.getTarget())
                    //.target(target)
                    .build()
            );
        }

        return responses;
    }
}
