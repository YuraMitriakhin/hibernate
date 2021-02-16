package com.gmail.yuramitryahin.dao;

import com.gmail.yuramitryahin.model.MovieSession;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MovieSessionDao {
    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);

    MovieSession add(MovieSession session);

    MovieSession update(MovieSession movieSession);

    void delete(Long id);

    Optional<MovieSession> get(Long id);
}
