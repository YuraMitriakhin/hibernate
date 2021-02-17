package com.gmail.yuramitryahin.service;

import com.gmail.yuramitryahin.model.User;
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
    public User register(String email, String password) {
        User user = User
                .builder()
                .email(email)
                .password(password)
                .build();
        userService.add(user);
        shoppingCartService.registerNewShoppingCart(user);
        return user;
    }
}
