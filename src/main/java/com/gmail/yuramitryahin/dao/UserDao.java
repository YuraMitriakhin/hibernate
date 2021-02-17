package com.gmail.yuramitryahin.dao;

import com.gmail.yuramitryahin.model.User;
import java.util.Optional;

public interface UserDao {
    User add(User user);

    Optional<User> findByEmail(String email);

    Optional<User> get(Long id);
}
