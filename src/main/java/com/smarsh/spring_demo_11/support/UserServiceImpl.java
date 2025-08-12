package com.smarsh.spring_demo_11.support;

import com.smarsh.spring_demo_11.model.User;
import com.smarsh.spring_demo_11.model.UserDB;
import com.smarsh.spring_demo_11.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;


public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;//=applicationCOntext.getBean("userRepository", UserRepository.class);

    public UserServiceImpl() {
    }

    @Override
    public void createUser(User user) {
        UserDB userDB = map(user);
        userRepository.save(userDB);
    }

    private static UserDB map(User user) {
        UserDB userDB = new UserDB();
        userDB.setUsername(user.getId());
        userDB.setPassword(user.getPassword());
        return userDB;
    }

    private static User map(UserDB userDB) {
        User User = new User();
        User.setId(userDB.getUsername());
        User.setPassword(userDB.getPassword());
        return User;
    }

    @Override
    public List<User> getUser() {
        //10
        //1 -> map -> user
        //2 -> map -> user
        //3 -> map -> user
        //4 -> map -> user

        return userRepository.findAll().stream().map(userDB -> map(userDB)).toList();
    }
}
