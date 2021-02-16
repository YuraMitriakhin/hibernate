package com.gmail.yuramitryahin.model.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieSessionRequestDto {
    private Long movieId;
    private Long cinemaHallId;
    private LocalDateTime showTime;
}
