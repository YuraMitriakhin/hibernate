package com.gmail.yuramitryahin.service.mapper;

import com.gmail.yuramitryahin.model.MovieSession;
import com.gmail.yuramitryahin.model.dto.MovieSessionRequestDto;
import com.gmail.yuramitryahin.model.dto.MovieSessionResponseDto;

public interface MovieSessionMapper {
    MovieSession toMovieSession(MovieSessionRequestDto movieSessionRequestDto);

    MovieSession toMovieSession(Long id, MovieSessionRequestDto movieSessionRequestDto);

    MovieSessionResponseDto toMovieSessionResponseDto(MovieSession movieSession);
}
