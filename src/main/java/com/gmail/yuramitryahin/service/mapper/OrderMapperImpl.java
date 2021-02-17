package com.gmail.yuramitryahin.service.mapper;

import com.gmail.yuramitryahin.model.Order;
import com.gmail.yuramitryahin.model.dto.OrderResponseDto;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OrderMapperImpl implements OrderMapper {
    @Override
    public OrderResponseDto toDto(Order order) {
        return OrderResponseDto.builder()
                .id(order.getId())
                .userId(order.getUser().getId())
                .orderDate(order.getOrderDate())
                .ticketIds(order.getTickets()
                        .stream()
                        .map(o -> o.getId())
                        .collect(Collectors.toList()))
                .build();
    }
}
