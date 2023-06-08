package com.authorization.jwt.security.jwt;

import com.authorization.jwt.controllers.Role;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JwtTokenProvider {

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
        return null;
    }
}
