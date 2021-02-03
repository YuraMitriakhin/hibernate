package com.gmail.yuramitryahin;

import com.gmail.yuramitryahin.exception.AuthenticationException;
import com.gmail.yuramitryahin.lib.Injector;
import com.gmail.yuramitryahin.model.Movie;
import com.gmail.yuramitryahin.model.MovieSession;
import com.gmail.yuramitryahin.model.User;
import com.gmail.yuramitryahin.service.AuthenticationService;
import com.gmail.yuramitryahin.service.MovieService;
import com.gmail.yuramitryahin.service.MovieSessionService;
import com.gmail.yuramitryahin.service.ShoppingCartService;

public class Main {
    private static Injector injector = Injector.getInstance("com.gmail.yuramitryahin");
    private static final AuthenticationService authenticationService
            = (AuthenticationService) injector.getInstance(AuthenticationService.class);
    private static final ShoppingCartService shoppingCartService = (ShoppingCartService) injector
            .getInstance(ShoppingCartService.class);
    private static final MovieSessionService movieSessionService = (MovieSessionService) injector
            .getInstance(MovieSessionService.class);
    private static final MovieService movieService = (MovieService) injector
            .getInstance(MovieService.class);
    private static final User user = authenticationService
            .register("user@gmail.com", "1234");

    public static void main(String[] args) throws AuthenticationException {
        MovieSession movieSession = new MovieSession();
        Movie movie = new Movie();
        movie.setTitle("Moana");
        movieSession.setMovie(movie);
        movieService.add(movie);
        movieSessionService.add(movieSession);
        shoppingCartService.addSession(movieSession, user);
        shoppingCartService.clear(shoppingCartService.getByUser(user));
        System.out.println(shoppingCartService.getByUser(user));
    }
}
