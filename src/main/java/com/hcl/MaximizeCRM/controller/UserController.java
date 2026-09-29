package com.hcl.MaximizeCRM.controller;

import com.hcl.MaximizeCRM.model.User;
import com.hcl.MaximizeCRM.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/users")
    public List<User> getUsers(){
        return userService.findAll();
    }

    @GetMapping("/api/users/{id}")
    public Optional<User> getUserById(@PathVariable Long id){
        return userService.findById(id);
    }

    @PostMapping("/api/users")
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    @DeleteMapping("/api/users/{id}")
    public void deleteUserById(@PathVariable Long id){
        userService.deleteById(id);
    }

}
