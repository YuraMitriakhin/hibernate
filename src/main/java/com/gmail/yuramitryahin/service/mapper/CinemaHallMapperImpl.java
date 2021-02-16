package com.gmail.yuramitryahin.service.mapper;

import com.gmail.yuramitryahin.model.CinemaHall;
import com.gmail.yuramitryahin.model.dto.CinemaHallRequestDto;
import com.gmail.yuramitryahin.model.dto.CinemaHallResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapperImpl implements CinemaHallMapper {
    @Override
    public CinemaHall toCinemaHall(CinemaHallRequestDto cinemaHallRequestDao) {
        return CinemaHall.builder()
                .description(cinemaHallRequestDao.getDescription())
                .capacity(cinemaHallRequestDao.getCapacity())
                .build();
    }

    @Override
    public CinemaHallResponseDto toCinemaHallResponseDao(CinemaHall cinemaHall) {
        return CinemaHallResponseDto.builder()
                .id(cinemaHall.getId())
                .capacity(cinemaHall.getCapacity())
                .description(cinemaHall.getDescription())
                .build();
    }
}
