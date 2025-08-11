package com.smarsh.spring_demo_11.support;

import com.smarsh.spring_demo_11.model.User;
import com.smarsh.spring_demo_11.model.UserDB;
import com.smarsh.spring_demo_11.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;//=applicationCOntext.getBean("userRepository", UserRepository.class);

    public UserServiceImpl() {
    }

    @Override
    public void createUser(User user) {
        UserDB userDB = new UserDB();
        userDB.setUsername(user.getId());
        userDB.setPassword(user.getPassword());
        userRepository.save(userDB);
    }

    @Override
    public User getUser() {
        return null;
    }
}
