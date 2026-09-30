package com.hcl.MaximizeCRM.service;


import com.hcl.MaximizeCRM.model.User;
import com.hcl.MaximizeCRM.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository ,  PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> findAll() {
        return  userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User save(User user) {
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public boolean login(String userEmail, String userPassword) {

        Optional<User> user = userRepository.findByUserEmail(userEmail);

        if (user.isEmpty()) {
            return false;
        }

        return passwordEncoder.matches(
                userPassword,
                user.get().getUserPassword()
        );
    }
    
}
