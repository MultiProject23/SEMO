package com.multi.shop.order.mapper;

import com.multi.shop.order.domain.dao.OrderSaveDAO;

public interface OrderMapper {
    Long save(OrderSaveDAO dao);
}