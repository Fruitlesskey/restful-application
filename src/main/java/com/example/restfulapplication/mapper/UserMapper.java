package com.example.restfulapplication.mapper;

import com.example.restfulapplication.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

public class UserMapper {
    public static UserDetails mapToCustomUser(User user) {
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getLogin())
                .password(user.getPassword())
                .build();
    }
}
