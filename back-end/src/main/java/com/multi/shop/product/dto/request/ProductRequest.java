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
    private String search;

    @Builder
    public ProductRequest(String search) {
        this.search = search;
    }
}
