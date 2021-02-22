package com.gmail.yuramitryahin.service;

import com.gmail.yuramitryahin.model.Role;

public interface RoleService {
    void add(Role role);

    Role getRoleByName(String roleName);
}
