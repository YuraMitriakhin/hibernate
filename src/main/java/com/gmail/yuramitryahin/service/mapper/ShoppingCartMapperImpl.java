package com.gmail.yuramitryahin.service.mapper;

import com.gmail.yuramitryahin.model.ShoppingCart;
import com.gmail.yuramitryahin.model.dto.ShoppingCartResponseDto;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartMapperImpl implements ShoppingCartMapper {
    @Override
    public ShoppingCartResponseDto toDto(ShoppingCart shoppingCart) {
        return ShoppingCartResponseDto.builder()
                .id(shoppingCart.getId())
                .ticketIds(shoppingCart.getTickets()
                        .stream()
                        .map(t -> t.getId())
                        .collect(Collectors.toList()))
                .build();
    }
}
