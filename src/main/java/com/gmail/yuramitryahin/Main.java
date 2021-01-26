package com.gmail.yuramitryahin;

import com.gmail.yuramitryahin.lib.Injector;
import com.gmail.yuramitryahin.model.Movie;
import com.gmail.yuramitryahin.service.MovieService;

public class Main {
    private static Injector injector = Injector.getInstance("com.gmail.yuramitryahin");

    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.setTitle("Fast and Furious");
        MovieService movieService = (MovieService) injector.getInstance(MovieService.class);
        System.out.println(movieService.add(movie));
        movieService.getAll().forEach(System.out::println);
    }
}
