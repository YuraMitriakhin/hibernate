package com.gmail.yuramitryahin.controller;

import com.gmail.yuramitryahin.model.dto.CinemaHallRequestDto;
import com.gmail.yuramitryahin.model.dto.CinemaHallResponseDto;
import com.gmail.yuramitryahin.service.CinemaHallService;
import com.gmail.yuramitryahin.service.mapper.CinemaHallMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {
    private final CinemaHallService cinemaHallService;
    private final CinemaHallMapper cinemaHallMapper;

    @Autowired
    public CinemaHallController(CinemaHallService cinemaHallService,
                                CinemaHallMapper cinemaHallMapper) {
        this.cinemaHallService = cinemaHallService;
        this.cinemaHallMapper = cinemaHallMapper;
    }

    @PostMapping
    public void add(CinemaHallRequestDto cinemaHallRequestDao) {
        cinemaHallService.add(cinemaHallMapper.toCinemaHall(cinemaHallRequestDao));
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAll() {
        return cinemaHallService.getAll().stream()
                .map(cinemaHallMapper::toCinemaHallResponseDao)
                .collect(Collectors.toList());
    }
}
