package com.gmail.yuramitryahin.dao;

import com.gmail.yuramitryahin.model.CinemaHall;
import java.util.List;

public interface CinemaHallDao {
    CinemaHall add(CinemaHall cinemaHall);

    List<CinemaHall> getAll();
}
