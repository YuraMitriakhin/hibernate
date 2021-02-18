package com.gmail.yuramitryahin.controller;

import com.gmail.yuramitryahin.model.dto.MovieRequestDto;
import com.gmail.yuramitryahin.model.dto.MovieResponseDto;
import com.gmail.yuramitryahin.service.MovieService;
import com.gmail.yuramitryahin.service.mapper.MovieMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final MovieMapper movieMapper;

    @Autowired
    public MovieController(MovieService movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    @PostMapping
    public void add(@RequestBody @Valid MovieRequestDto movieRequestDto) {
        movieService.add(movieMapper.toMovie(movieRequestDto));
    }

    @GetMapping
    public List<MovieResponseDto> getAll() {
        return movieService.getAll().stream()
                .map(movieMapper::toMovieResponseDto)
                .collect(Collectors.toList());
    }
}
