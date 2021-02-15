package com.gmail.yuramitryahin.model.dto;

import com.gmail.yuramitryahin.model.CinemaHall;
import com.gmail.yuramitryahin.model.Movie;
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
public class MovieSessionResponseDto {
    private Long id;
    private Movie movie;
    private CinemaHall cinemaHall;
    private LocalDateTime showTime;
}
