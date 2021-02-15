package com.gmail.yuramitryahin.model.dto;

import com.gmail.yuramitryahin.model.CinemaHall;
import com.gmail.yuramitryahin.model.Movie;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieSessionResponseDto {
    private Long id;
    private Movie movie;
    private CinemaHall cinemaHall;
    private LocalDateTime showTime;
}
