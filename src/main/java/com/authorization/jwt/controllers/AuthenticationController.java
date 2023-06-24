package com.authorization.jwt.controllers;

import com.authorization.jwt.dto.AuthDto;
import com.authorization.jwt.entities.User;
import com.authorization.jwt.security.jwt.JwtTokenProvider;
import com.authorization.jwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.security.core.AuthenticationException;

import java.util.Hashtable;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserService userService;

    public ResponseEntity login(@RequestBody AuthDto authDto) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authDto.getUsername(), authDto.getPassword()));
            User user = userService.getByUsername(authDto.getUsername());
            if (user == null) {
                throw new UsernameNotFoundException("User was not found");
            }
            String token = jwtTokenProvider.createToken(authDto.getUsername(), user.getRoles());

            Map<Object, Object> response = new Hashtable<>();
            response.put("username", user.getUsername());
            response.put("token", token);

            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid login and/or password");
        }
    }
}
