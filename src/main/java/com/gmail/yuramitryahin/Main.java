package com.gmail.yuramitryahin;

import com.gmail.yuramitryahin.exception.AuthenticationException;
import com.gmail.yuramitryahin.lib.Injector;
import com.gmail.yuramitryahin.model.User;
import com.gmail.yuramitryahin.service.AuthenticationService;

public class Main {
    private static Injector injector = Injector.getInstance("com.gmail.yuramitryahin");

    public static void main(String[] args) throws AuthenticationException {
        User user = new User();
        user.setEmail("user@gmail.com");
        user.setPassword("1234");
        AuthenticationService authenticationService = (AuthenticationService) injector
                .getInstance(AuthenticationService.class);
        System.out.println(authenticationService.register(user.getEmail(), user.getPassword()));
        System.out.println(authenticationService.login(user.getEmail(), user.getPassword()));
    }
}
