package com.multi.shop.product.mapper;

import com.multi.shop.product.domain.vo.ProductVO;
import com.multi.shop.product.dto.ProductDTO;

import java.util.List;

public interface ProductMapper {
    List<ProductVO> selectListProduct(ProductDTO dto);
}
