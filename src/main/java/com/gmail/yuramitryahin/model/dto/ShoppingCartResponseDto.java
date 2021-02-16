package com.gmail.yuramitryahin.model.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCartResponseDto {
    private long id;
    private List<Long> ticketIds;
}
