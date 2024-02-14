package com.goit.users;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    public final UserRepository repository;
    public User findByUsername(String username) {
        return repository.findById(username).orElse(null);
    }
}