package com.gmail.yuramitryahin;

import com.gmail.yuramitryahin.lib.Injector;
import com.gmail.yuramitryahin.model.CinemaHall;
import com.gmail.yuramitryahin.model.Movie;
import com.gmail.yuramitryahin.model.MovieSession;
import com.gmail.yuramitryahin.service.CinemaHallService;
import com.gmail.yuramitryahin.service.MovieService;
import com.gmail.yuramitryahin.service.MovieSessionService;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    private static Injector injector = Injector.getInstance("com.gmail.yuramitryahin");

    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.setTitle("Fast and Furious");
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(50);
        MovieSession movieSession = new MovieSession();
        movieSession.setCinemaHall(cinemaHall);
        movieSession.setMovie(movie);
        movieSession.setShowTime(LocalDateTime.now());
        MovieService movieService = (MovieService) injector.getInstance(MovieService.class);
        CinemaHallService cinemaHallService = (CinemaHallService) injector
                .getInstance(CinemaHallService.class);
        MovieSessionService movieSessionService = (MovieSessionService) injector
                .getInstance(MovieSessionService.class);
        movieService.add(movie);
        cinemaHallService.add(cinemaHall);
        movieSessionService.add(movieSession);
        System.out.println(movieSessionService.findAvailableSessions(movie.getId(),
                LocalDate.now()));
    }
}
