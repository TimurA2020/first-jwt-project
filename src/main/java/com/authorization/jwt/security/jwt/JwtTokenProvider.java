package com.authorization.jwt.security.jwt;

import com.authorization.jwt.controllers.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sun.security.util.Password;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtTokenProvider {

    @Value("${jwt.token.secret}")
    private String secret;

    @Value("${jwt.token.expired}")
    private Long expirationTime;

    @Autowired
    private UserDetailsService userDetailsService;

    public String createToken(String username, List<Role> roleList) {
        return null;
    }

    public Authentication getAuth(String token) {
        return null;
    }

    public String getNameByToken(String token) {
        return null;
    }

    public boolean validateToken(String token) {
        return false;
    }

    private List<String> getRoleNames(List<Role> roles) {
        List<String> rolesResult = new ArrayList<>();
        roles.forEach(x -> rolesResult.add(x.getName()));
        return rolesResult;
    }
}
