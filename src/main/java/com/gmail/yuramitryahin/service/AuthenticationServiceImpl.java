package com.gmail.yuramitryahin.service;

import com.gmail.yuramitryahin.exception.AuthenticationException;
import com.gmail.yuramitryahin.hasher.HashUtil;
import com.gmail.yuramitryahin.model.User;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;

    @Autowired
    public AuthenticationServiceImpl(UserService userService,
                                     ShoppingCartService shoppingCartService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public User login(String email, String password) throws AuthenticationException {
        Optional<User> optionalUser = userService.findByEmail(email);
        if (optionalUser.isPresent()
                && HashUtil.checkPassword(optionalUser.get().getPassword(),
                password, optionalUser.get().getSalt())) {
            return optionalUser.get();
        }
        throw new AuthenticationException("Incorrect login or password!");
    }

    @Override
    public User register(String email, String password) {
        User user = new User(email, password);
        userService.add(user);
        shoppingCartService.registerNewShoppingCart(user);
        return user;
    }
}
