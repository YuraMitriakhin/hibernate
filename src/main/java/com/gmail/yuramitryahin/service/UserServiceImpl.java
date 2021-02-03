package com.gmail.yuramitryahin.service;

import com.gmail.yuramitryahin.dao.UserDao;
import com.gmail.yuramitryahin.hasher.HashUtil;
import com.gmail.yuramitryahin.lib.Inject;
import com.gmail.yuramitryahin.lib.Service;
import com.gmail.yuramitryahin.model.User;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Inject
    private UserDao userDao;

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
