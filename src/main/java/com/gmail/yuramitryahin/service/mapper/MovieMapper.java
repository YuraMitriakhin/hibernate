package com.gmail.yuramitryahin.service.mapper;

import com.gmail.yuramitryahin.model.Movie;
import com.gmail.yuramitryahin.model.dto.MovieRequestDto;
import com.gmail.yuramitryahin.model.dto.MovieResponseDto;

public interface MovieMapper {
    Movie toMovie(MovieRequestDto movieRequestDto);

    MovieResponseDto toMovieResponseDto(Movie movie);
}
