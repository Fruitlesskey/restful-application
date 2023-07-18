package com.example.restfulapplication.controller;

import com.example.restfulapplication.exception.EmployeeException;
import com.example.restfulapplication.payload.AuthRequest;
import com.example.restfulapplication.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final CustomUserDetailsService userDetailsService;

    @PostMapping
    public UserDetails login(@RequestBody AuthRequest authRequest) throws EmployeeException {
        return userDetailsService.loadUserByUsername(authRequest.getUsername());
    }
}
