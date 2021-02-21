package com.gmail.yuramitryahin.security;

import static org.springframework.security.core.userdetails.User.withUsername;

import com.gmail.yuramitryahin.model.Role;
import com.gmail.yuramitryahin.model.User;
import com.gmail.yuramitryahin.service.UserService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImp implements UserDetailsService {
    private final UserService userService;

    @Autowired
    public UserDetailsServiceImp(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByEmail(username).orElseThrow(() ->
                new UsernameNotFoundException("User not found!"));
        UserBuilder builder = null;
        builder = withUsername(username);
        builder.password(user.getPassword());
        builder.roles(getStringRoles(user.getRole()));
        return builder.build();
    }

    private String[] getStringRoles(Set<Role> roleSet) {
        return roleSet
                .stream()
                .map(role -> role.getRoleType().toString())
                .toArray(String[]::new);
    }
}
