package com.gmail.yuramitryahin.service.mapper;

import com.gmail.yuramitryahin.model.MovieSession;
import com.gmail.yuramitryahin.model.dto.MovieSessionRequestDto;
import com.gmail.yuramitryahin.model.dto.MovieSessionResponseDto;
import com.gmail.yuramitryahin.service.CinemaHallService;
import com.gmail.yuramitryahin.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapperImpl implements MovieSessionMapper {
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;

    @Autowired
    public MovieSessionMapperImpl(MovieService movieService, CinemaHallService cinemaHallService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    @Override
    public MovieSession toMovieSession(MovieSessionRequestDto movieSessionRequestDto) {
        return MovieSession.builder()
                .movie(movieService.get(movieSessionRequestDto.getMovieId()))
                .cinemaHall(cinemaHallService.get(movieSessionRequestDto.getCinemaHallId()))
                .showTime(movieSessionRequestDto.getShowTime())
                .build();
    }

    @Override
    public MovieSession toMovieSession(Long id, MovieSessionRequestDto movieSessionRequestDto) {
        return MovieSession.builder()
                .id(id)
                .movie(movieService.get(movieSessionRequestDto.getMovieId()))
                .cinemaHall(cinemaHallService.get(movieSessionRequestDto.getCinemaHallId()))
                .showTime(movieSessionRequestDto.getShowTime())
                .build();
    }

    @Override
    public MovieSessionResponseDto toMovieSessionResponseDto(MovieSession movieSession) {
        return MovieSessionResponseDto.builder()
                .id(movieSession.getId())
                .cinemaHall(movieSession.getCinemaHall())
                .movie(movieSession.getMovie())
                .showTime(movieSession.getShowTime())
                .build();
    }
}
