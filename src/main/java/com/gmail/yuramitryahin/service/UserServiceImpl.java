package com.gmail.yuramitryahin.service;

import com.gmail.yuramitryahin.dao.UserDao;
import com.gmail.yuramitryahin.hasher.HashUtil;
import com.gmail.yuramitryahin.model.User;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User add(User user) {
        byte[] salt = HashUtil.generateSalt();
        user.setSalt(salt);
        user.setPassword(HashUtil.hash(user.getPassword(), salt));
        return userDao.add(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
