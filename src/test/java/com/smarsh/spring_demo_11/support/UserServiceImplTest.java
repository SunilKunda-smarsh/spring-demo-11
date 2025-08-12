package com.smarsh.spring_demo_11.support;

import com.smarsh.spring_demo_11.model.User;
import com.smarsh.spring_demo_11.model.UserDB;
import com.smarsh.spring_demo_11.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImplTest {
    private UserRepository userRepository = Mockito.mock(UserRepository.class);
    private UserServiceImpl userService = new UserServiceImpl(userRepository);




    @BeforeEach
    public void setUp() {
        //Mockito.reset(userRepository);
    }

    @Test
    public void testCreateUser() {
        userService.createUser(new User());
        Mockito.verify(userRepository).save(Mockito.any());
        Mockito.verifyNoMoreInteractions(userRepository);
    }

    @Test
    public void testGetuser(){
        /**
         *
         * 1. creation of data
         * 2. call the method
         * 3. verify the data
         * */
        List<UserDB> userList   = new ArrayList<>();
        userList.add(new UserDB());
        Mockito.when(userRepository.findAll()).thenReturn(userList);

        List<User> user = userService.getUser();



        Assertions.assertThat(user).isNotNull().hasSize(1);
        Mockito.verify(userRepository).findAll();
        Mockito.verifyNoMoreInteractions(userRepository);
    }
}
