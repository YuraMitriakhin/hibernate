package com.gmail.yuramitryahin.service;

import com.gmail.yuramitryahin.dao.RoleDao;
import com.gmail.yuramitryahin.model.Role;
import com.gmail.yuramitryahin.model.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void add(Role role) {
        roleDao.add(role);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleDao.getRoleByName(RoleType.valueOf(roleName.toUpperCase()));
    }
}
