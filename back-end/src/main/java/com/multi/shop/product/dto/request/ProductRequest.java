package com.multi.shop.product.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductRequest {
    @NotNull
    private String target;

    @NotNull
    private String category;

    @Builder
    public ProductRequest(String target, String category) {
        this.target = target;
        this.category = category;
    }
}
