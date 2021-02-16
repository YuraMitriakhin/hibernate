package com.gmail.yuramitryahin.service.mapper;

import com.gmail.yuramitryahin.model.Movie;
import com.gmail.yuramitryahin.model.dto.MovieRequestDto;
import com.gmail.yuramitryahin.model.dto.MovieResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MovieMapperImpl implements MovieMapper {
    @Override
    public Movie toMovie(MovieRequestDto movieRequestDto) {
        return Movie.builder()
                .description(movieRequestDto.getDescription())
                .title(movieRequestDto.getTitle())
                .build();
    }

    @Override
    public MovieResponseDto toMovieResponseDto(Movie movie) {
        return MovieResponseDto.builder()
                .id(movie.getId())
                .description(movie.getDescription())
                .title(movie.getTitle())
                .build();
    }
}
