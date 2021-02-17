package com.gmail.yuramitryahin.service.mapper;

import com.gmail.yuramitryahin.model.Order;
import com.gmail.yuramitryahin.model.dto.OrderResponseDto;

public interface OrderMapper {
    OrderResponseDto toDto(Order order);
}
