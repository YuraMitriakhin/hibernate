package com.gmail.yuramitryahin.model.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieRequestDto {
    @NotNull
    @Size(min = 3)
    private String title;
    @NotNull
    @Size(min = 10)
    private String description;
}
