package com.gmail.yuramitryahin.service;

import com.gmail.yuramitryahin.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
