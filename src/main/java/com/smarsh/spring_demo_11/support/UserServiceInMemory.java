package com.smarsh.spring_demo_11.support;

import com.smarsh.spring_demo_11.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
public class UserServiceInMemory implements UserService {

    @Value("${user.service.id}")
    private String is;




    public UserServiceInMemory() {
        // Constructor logic if needed
        log.info("UserService initialized");
    }

    public void createUser(User user) {
        // Logic to create a user
        log.info("User created: {}", user);
    }

    public List<User> getUser(){
        // Logic to get a user
        log.info("Retrieving user");
        User user = new User();
        user.setId(is);
        user.setPassword("password123");
        log.info("User retrieved: {}", user);
        return List.of(user);
    }
}
