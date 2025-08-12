package com.smarsh.spring_demo_11.support;

import com.smarsh.spring_demo_11.model.User;

import java.util.List;

public interface UserService {
    public void createUser(User user);

    public List<User> getUser();
}



