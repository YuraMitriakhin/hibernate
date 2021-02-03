package com.gmail.yuramitryahin.service;

import com.gmail.yuramitryahin.exception.AuthenticationException;
import com.gmail.yuramitryahin.model.User;

public interface AuthenticationService {
    User login(String email, String password) throws AuthenticationException;

    User register(String email, String password);
}
