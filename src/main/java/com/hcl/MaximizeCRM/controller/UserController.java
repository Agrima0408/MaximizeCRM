package com.hcl.MaximizeCRM.controller;

//import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.MaximizeCRM.model.User;
import com.hcl.MaximizeCRM.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @Autowired
//    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;
//
//    @Autowired
//    private ObjectMapper objectMapper;

//    @GetMapping("/api/test-converters")
//    public List<String> testConverters() {
//        return requestMappingHandlerAdapter.getMessageConverters()
//                .stream()
//                .map(converter ->
//                        converter.getClass().getName()
//                                + " -> "
//                                + converter.getSupportedMediaTypes()
//                )
//                .toList();
//    }

    @GetMapping("/api/users")
    public List<User> getUsers(){
        return userService.findAll();
    }

    @GetMapping("/api/users/{id}")
    public Optional<User> getUserById(@PathVariable Long id){
        return userService.findById(id);
    }

    @PostMapping("/api/users")
    public User save(@Valid @RequestBody User user){
        return userService.save(user);
    }

//    @PostMapping("/api/test-json")
//    public String testJson(@RequestBody String body) {
//        return body;
//    }
//
//    @PostMapping("/api/test-user-json")
//    public String testUserJson(@RequestBody String body) {
//        try {
//            User user = objectMapper.readValue(body, User.class);
//            return "SUCCESS: " + user.getUserName();
//        } catch (Exception e) {
//            return "ERROR: " + e.getClass().getName() + " - " + e.getMessage();
//        }
//    }

    @DeleteMapping("/api/users/{id}")
    public void deleteUserById(@PathVariable Long id){
        userService.deleteById(id);
    }

}
