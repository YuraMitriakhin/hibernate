package com.gmail.yuramitryahin.controller;

import com.gmail.yuramitryahin.model.dto.MovieSessionRequestDto;
import com.gmail.yuramitryahin.model.dto.MovieSessionResponseDto;
import com.gmail.yuramitryahin.service.MovieSessionService;
import com.gmail.yuramitryahin.service.mapper.MovieSessionMapper;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie-sessions")
public class MovieSessionController {
    private final MovieSessionService movieSessionService;
    private final MovieSessionMapper movieSessionMapper;

    @Autowired
    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionMapper movieSessionMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionMapper = movieSessionMapper;
    }

    @PostMapping
    public void add(@RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        movieSessionService.add(movieSessionMapper.toMovieSession(movieSessionRequestDto));
    }

    @PutMapping("/{id}")
    public void put(@PathVariable("id") Long id,
                    @RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        movieSessionService.update(movieSessionMapper.toMovieSession(id, movieSessionRequestDto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        movieSessionService.delete(id);
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> allAvailable(@RequestParam Long id,
                            @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date) {
        return movieSessionService.findAvailableSessions(id, date)
                .stream()
                .map(movieSessionMapper::toMovieSessionResponseDto)
                .collect(Collectors.toList());
    }

}
