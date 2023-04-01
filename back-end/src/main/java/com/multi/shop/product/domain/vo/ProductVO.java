package com.multi.shop.product.domain.vo;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductVO {
    private String id;
    private String category;
    private String image;
    private String info;
    private String name;
    private int price;
    private int stock;
    private String target;

    @Builder
    public ProductVO(String id,String category,String image,String info,String name,int price,int stock,String target) {
        this.id = id;
        this.category = category;
        this.image = image;
        this.info = info;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.target = target;
    }
}
