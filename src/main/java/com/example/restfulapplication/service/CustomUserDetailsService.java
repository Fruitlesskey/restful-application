package com.example.restfulapplication.service;

import com.example.restfulapplication.entity.User;
import com.example.restfulapplication.mapper.UserMapper;
import com.example.restfulapplication.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    //    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByLogin(username)
                .orElseThrow(() -> new EntityNotFoundException("User was not found"));
        return UserMapper.mapToCustomUser(user);
    }
}
