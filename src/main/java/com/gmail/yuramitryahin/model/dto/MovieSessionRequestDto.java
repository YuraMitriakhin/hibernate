package com.gmail.yuramitryahin.model.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MovieSessionRequestDto {
    private Long movieId;
    private Long cinemaHallId;
    private LocalDateTime showTime;
}
