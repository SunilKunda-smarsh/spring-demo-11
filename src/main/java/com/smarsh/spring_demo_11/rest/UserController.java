package com.smarsh.spring_demo_11.rest;

import com.smarsh.spring_demo_11.model.User;
import com.smarsh.spring_demo_11.support.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;

    public UserController(@Qualifier("userServiceImpl") UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/users")
    public String createUser(@RequestBody User user) {
        userService.createUser(user);
        return "User created successfully: " + user.getId();
    }

    @GetMapping("/users")
    public User getUser() {
        return userService.getUser();
    }
}
