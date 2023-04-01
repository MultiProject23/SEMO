package com.multi.shop.product.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class ProductDTO {
    private String search;

    @Builder
    public ProductDTO(String search) {
        this.search = search;
    }
}
