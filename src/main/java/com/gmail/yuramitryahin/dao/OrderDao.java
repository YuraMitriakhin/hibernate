package com.gmail.yuramitryahin.dao;

import com.gmail.yuramitryahin.model.Order;
import com.gmail.yuramitryahin.model.User;
import java.util.List;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
