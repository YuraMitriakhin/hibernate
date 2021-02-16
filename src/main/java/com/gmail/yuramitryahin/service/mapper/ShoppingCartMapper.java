package com.gmail.yuramitryahin.service.mapper;

import com.gmail.yuramitryahin.model.ShoppingCart;
import com.gmail.yuramitryahin.model.dto.ShoppingCartResponseDto;

public interface ShoppingCartMapper {
    ShoppingCartResponseDto toDto(ShoppingCart shoppingCart);
}
