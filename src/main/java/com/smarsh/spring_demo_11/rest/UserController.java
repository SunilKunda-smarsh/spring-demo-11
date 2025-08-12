package com.smarsh.spring_demo_11.rest;

import com.smarsh.spring_demo_11.model.User;
import com.smarsh.spring_demo_11.support.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
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
    public List<User> getUser() {
        return userService.getUser();
    }

    @GetMapping("/user")
    public User getUserById(@RequestParam String id) {
        return userService.getUser().stream().filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}



/*
*
*
*     http://localhost:8080/users/{id} -> http://localhost:8080/users/123
*
* http://localhost:8080/users?id={id}   -> http://localhost:8080/users?id=123
*
*
 */
