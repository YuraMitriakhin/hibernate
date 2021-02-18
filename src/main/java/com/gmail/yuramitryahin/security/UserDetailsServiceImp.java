package com.gmail.yuramitryahin.security;

import com.gmail.yuramitryahin.model.Role;
import com.gmail.yuramitryahin.model.User;
import com.gmail.yuramitryahin.service.UserService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImp implements UserDetailsService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserDetailsServiceImp(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByEmail(username).orElseThrow(() ->
                new UsernameNotFoundException("User not found!"));
        org.springframework.security.core.userdetails.User.UserBuilder builder = null;
        builder = org.springframework.security.core.userdetails.User.withUsername(username);
        builder.password(user.getPassword());
        builder.roles(getStringRoles(user.getRole()));
        return builder.build();
    }

    private String[] getStringRoles(Set<Role> roleSet) {
        String[] roles = new String[roleSet.size()];
        int i = 0;
        for (Role role : roleSet) {
            roles[i++] = role.getRoleType().name();
        }
        return roles;
    }
}
