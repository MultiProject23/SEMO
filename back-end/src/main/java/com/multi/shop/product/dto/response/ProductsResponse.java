package com.multi.shop.product.dto.response;

import com.p6spy.engine.logging.Category;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.annotation.Target;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductsResponse {
    private Long id;
    private String image;
    private String name;
    private int price;
    private String category;
    private String target;

    @Builder
    public ProductsResponse(Long id, String image, String name, int price, String category, String target) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.price = price;
        this.category = category;
        this.target = target;



    }
}
