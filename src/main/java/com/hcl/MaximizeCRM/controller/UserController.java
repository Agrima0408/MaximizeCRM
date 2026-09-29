package com.hcl.MaximizeCRM.controller;


import com.hcl.MaximizeCRM.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    UserService userService;
    @Autowired
    public void  setUserService(UserService userService) {
        this.userService = userService;
    }
}
