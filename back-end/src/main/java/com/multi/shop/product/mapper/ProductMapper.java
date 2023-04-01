package com.multi.shop.product.mapper;

import com.multi.shop.product.dto.ProductDTO;

public interface ProductMapper {
    Long selectListProduct(ProductDTO dto);
}
