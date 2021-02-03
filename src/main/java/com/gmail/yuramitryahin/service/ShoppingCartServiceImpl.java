package com.gmail.yuramitryahin.service;

import com.gmail.yuramitryahin.dao.ShoppingCartDao;
import com.gmail.yuramitryahin.dao.TicketDao;
import com.gmail.yuramitryahin.lib.Inject;
import com.gmail.yuramitryahin.lib.Service;
import com.gmail.yuramitryahin.model.MovieSession;
import com.gmail.yuramitryahin.model.ShoppingCart;
import com.gmail.yuramitryahin.model.Ticket;
import com.gmail.yuramitryahin.model.User;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Inject
    private ShoppingCartDao shoppingCartDao;
    @Inject
    private TicketDao ticketDao;

    @Override
    public void addSession(MovieSession movieSession, User user) {
        Ticket ticket = new Ticket();
        ticket.setMovieSession(movieSession);
        ticket.setUser(user);
        ticketDao.add(ticket);
        ShoppingCart shoppingCart = shoppingCartDao.getByUser(user);
        shoppingCart.getTickets().add(ticket);
        shoppingCartDao.update(shoppingCart);
    }

    @Override
    public ShoppingCart getByUser(User user) {
        return shoppingCartDao.getByUser(user);
    }

    @Override
    public void registerNewShoppingCart(User user) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        shoppingCartDao.add(shoppingCart);
    }

    @Override
    public void clear(ShoppingCart shoppingCart) {
        shoppingCart.getTickets().clear();
        shoppingCartDao.update(shoppingCart);
    }
}
