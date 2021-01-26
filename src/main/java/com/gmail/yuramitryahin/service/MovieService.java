package com.gmail.yuramitryahin.service;

import com.gmail.yuramitryahin.model.Movie;
import java.util.List;

public interface MovieService {
    Movie add(Movie movie);

    List<Movie> getAll();
}
