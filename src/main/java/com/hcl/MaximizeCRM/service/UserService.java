package com.hcl.MaximizeCRM.service;


import com.hcl.MaximizeCRM.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    
}
