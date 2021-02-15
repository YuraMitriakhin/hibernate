package com.gmail.yuramitryahin.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CinemaHallResponseDto {
    private Long id;
    private int capacity;
    private String description;
}
