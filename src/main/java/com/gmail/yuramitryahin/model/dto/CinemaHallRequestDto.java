package com.gmail.yuramitryahin.model.dto;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CinemaHallRequestDto {
    @NotNull
    private Integer capacity;
    @NotNull
    private String description;
}
