package com.gmail.yuramitryahin.service;

import com.gmail.yuramitryahin.model.CinemaHall;
import java.util.List;

public interface CinemaHallService {
    CinemaHall add(CinemaHall cinemaHall);

    List<CinemaHall> getAll();
}
