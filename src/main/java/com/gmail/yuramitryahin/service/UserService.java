package com.gmail.yuramitryahin.service;

import com.gmail.yuramitryahin.model.User;
import java.util.Optional;

public interface UserService {
    User add(User user);

    Optional<User> findByEmail(String email);
}
