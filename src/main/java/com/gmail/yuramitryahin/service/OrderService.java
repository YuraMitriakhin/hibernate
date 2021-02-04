package com.gmail.yuramitryahin.service;

import com.gmail.yuramitryahin.model.Order;
import com.gmail.yuramitryahin.model.ShoppingCart;
import com.gmail.yuramitryahin.model.User;
import java.util.List;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
