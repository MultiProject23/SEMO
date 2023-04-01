package com.multi.shop.product.mapper;

import com.multi.shop.product.domain.dao.ProductDAO;

public interface ProductMapper {
    Long selectListProduct(ProductDAO dao);
}
