package com.gmail.yuramitryahin.service;

import com.gmail.yuramitryahin.model.MovieSession;
import com.gmail.yuramitryahin.model.ShoppingCart;
import com.gmail.yuramitryahin.model.User;

public interface ShoppingCartService {
    void addSession(MovieSession movieSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
