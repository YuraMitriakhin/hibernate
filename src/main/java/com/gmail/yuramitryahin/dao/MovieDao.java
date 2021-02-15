package com.gmail.yuramitryahin.dao;

import com.gmail.yuramitryahin.model.Movie;
import java.util.List;

public interface MovieDao {
    Movie add(Movie movie);

    List<Movie> getAll();

    Movie get(Long id);
}
