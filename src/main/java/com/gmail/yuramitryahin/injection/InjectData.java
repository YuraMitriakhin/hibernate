package com.gmail.yuramitryahin.injection;

import com.gmail.yuramitryahin.model.Role;
import com.gmail.yuramitryahin.model.RoleType;
import com.gmail.yuramitryahin.model.User;
import com.gmail.yuramitryahin.service.RoleService;
import com.gmail.yuramitryahin.service.UserService;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InjectData {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public InjectData(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void inject() {
        Role userRole = new Role();
        userRole.setRoleType(RoleType.USER);
        Role adminRole = new Role();
        adminRole.setRoleType(RoleType.ADMIN);
        roleService.add(userRole);
        roleService.add(adminRole);
        User admin = User.builder()
                .email("admin")
                .password("1234")
                .role(Set.of(adminRole))
                .build();
        userService.add(admin);
    }
}
