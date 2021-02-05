package com.gmail.yuramitryahin;

import com.gmail.yuramitryahin.exception.AuthenticationException;
import com.gmail.yuramitryahin.lib.Injector;
import com.gmail.yuramitryahin.model.Movie;
import com.gmail.yuramitryahin.model.MovieSession;
import com.gmail.yuramitryahin.model.User;
import com.gmail.yuramitryahin.service.AuthenticationService;
import com.gmail.yuramitryahin.service.MovieService;
import com.gmail.yuramitryahin.service.MovieSessionService;
import com.gmail.yuramitryahin.service.OrderService;
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
    private static final OrderService orderService = (OrderService) injector
            .getInstance(OrderService.class);

    public static void main(String[] args) throws AuthenticationException {
        MovieSession firstSession = new MovieSession();
        Movie moana = new Movie();
        Movie shrek = new Movie();
        shrek.setTitle("Shrek");
        moana.setTitle("Moana");
        firstSession.setMovie(moana);

        MovieSession secondSession = new MovieSession();
        secondSession.setMovie(shrek);
        movieService.add(moana);
        movieService.add(shrek);
        movieSessionService.add(firstSession);
        movieSessionService.add(secondSession);
        User user = authenticationService
                .register("user@gmail.com", "1234");
        shoppingCartService.addSession(firstSession, user);
        shoppingCartService.addSession(secondSession, user);
        orderService.completeOrder(shoppingCartService.getByUser(user));
        System.out.println(orderService.getOrdersHistory(user));
    }
}
