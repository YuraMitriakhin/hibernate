package com.gmail.yuramitryahin.service.mapper;

import com.gmail.yuramitryahin.model.CinemaHall;
import com.gmail.yuramitryahin.model.dto.CinemaHallRequestDto;
import com.gmail.yuramitryahin.model.dto.CinemaHallResponseDto;

public interface CinemaHallMapper {
    CinemaHall toCinemaHall(CinemaHallRequestDto cinemaHallRequestDao);

    CinemaHallResponseDto toCinemaHallResponseDao(CinemaHall cinemaHall);
}
