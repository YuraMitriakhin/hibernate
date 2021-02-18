package com.gmail.yuramitryahin.dao;

import com.gmail.yuramitryahin.model.Role;
import com.gmail.yuramitryahin.model.RoleType;

public interface RoleDao {
    void add(Role role);

    Role getRoleByName(RoleType roleType);
}
