package com.gmail.yuramitryahin.service;

import com.gmail.yuramitryahin.model.User;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final RoleService roleService;

    @Autowired
    public AuthenticationServiceImpl(UserService userService,
                         ShoppingCartService shoppingCartService, RoleService roleService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.roleService = roleService;
    }

    @Override
    public User register(String email, String password) {
        User user = User
                .builder()
                .email(email)
                .password(password)
                .role(Set.of(roleService.getRoleByName("user")))
                .build();
        userService.add(user);
        shoppingCartService.registerNewShoppingCart(user);
        return user;
    }
}
