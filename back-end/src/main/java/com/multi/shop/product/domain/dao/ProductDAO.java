package com.multi.shop.product.domain.dao;

import com.multi.shop.member.domain.Role;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ProductDAO {
    private String target;
    private String category;
    @Builder
    public ProductDAO(String target, String category) {
        this.target = target;
        this.category = category;
    }
}
