package com.gmail.yuramitryahin.service;

import com.gmail.yuramitryahin.exception.AuthenticationException;
import com.gmail.yuramitryahin.hasher.Sha512Hasher;
import com.gmail.yuramitryahin.lib.Inject;
import com.gmail.yuramitryahin.lib.Service;
import com.gmail.yuramitryahin.model.User;
import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Inject
    private UserService userService;

    @Override
    public User login(String email, String password) throws AuthenticationException {
        Optional<User> optionalUser = userService.findByEmail(email);
        if (optionalUser.isPresent()
                && Sha512Hasher.checkPassword(optionalUser.get().getPassword(),
                password, optionalUser.get().getSalt())) {
            return optionalUser.get();
        }
        throw new AuthenticationException("Incorrect login or password!");
    }

    @Override
    public User register(String email, String password) {
        return userService.add(new User(email, password));
    }
}
