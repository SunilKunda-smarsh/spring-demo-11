package com.smarsh.spring_demo_11.config;

import com.smarsh.spring_demo_11.repository.UserRepository;
import com.smarsh.spring_demo_11.support.UserService;
import com.smarsh.spring_demo_11.support.UserServiceImpl;
import com.smarsh.spring_demo_11.support.UserServiceInMemory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

   @Bean
   @Qualifier("userServiceImpl")
    public UserService userService() {
        return new UserServiceImpl();
    }

    @Bean
    @Qualifier("userServiceInMemory")
    public UserService userServiceInMemory() {
        return new UserServiceInMemory();
    }
}
