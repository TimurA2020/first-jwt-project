package com.authorization.jwt.security;

import com.authorization.jwt.entities.User;
import com.authorization.jwt.security.jwt.JwtUser;
import com.authorization.jwt.security.jwt.JwtUserFactory;
import com.authorization.jwt.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class JwtService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User with username " + username + " was not found");
        }

        JwtUser jwtUser = JwtUserFactory.create(user);
        log.info("user {} was loaded", username);
        return jwtUser;
    }
}
