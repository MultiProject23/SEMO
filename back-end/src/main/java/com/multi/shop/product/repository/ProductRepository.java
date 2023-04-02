package com.multi.shop.product.repository;

import com.multi.shop.product.domain.vo.ProductVO;
import com.multi.shop.product.dto.ProductDTO;
import com.multi.shop.product.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ProductRepository {
    private final ProductMapper productMapper;

    public List<ProductVO> getProducts(String search) {
        ProductDTO dto = new ProductDTO(search);
        return productMapper.selectListProduct(dto);
    }


}
