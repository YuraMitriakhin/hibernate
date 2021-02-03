package com.gmail.yuramitryahin.dao;

import com.gmail.yuramitryahin.model.ShoppingCart;
import com.gmail.yuramitryahin.model.User;

public interface ShoppingCartDao {
    ShoppingCart add(ShoppingCart shoppingCart);

    ShoppingCart getByUser(User user);

    void update(ShoppingCart shoppingCart);
}
