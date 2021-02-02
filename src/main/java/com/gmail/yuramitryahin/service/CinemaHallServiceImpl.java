package com.gmail.yuramitryahin.service;

import com.gmail.yuramitryahin.dao.CinemaHallDao;
import com.gmail.yuramitryahin.lib.Inject;
import com.gmail.yuramitryahin.lib.Service;
import com.gmail.yuramitryahin.model.CinemaHall;
import java.util.List;

@Service
public class CinemaHallServiceImpl implements CinemaHallService {
    @Inject
    private CinemaHallDao cinemaHallDao;

    @Override
    public CinemaHall add(CinemaHall cinemaHall) {
        return cinemaHallDao.add(cinemaHall);
    }

    @Override
    public List<CinemaHall> getAll() {
        return cinemaHallDao.getAll();
    }
}
