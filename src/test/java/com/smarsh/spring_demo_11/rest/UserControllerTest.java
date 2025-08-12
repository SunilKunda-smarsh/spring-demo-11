package com.smarsh.spring_demo_11.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smarsh.spring_demo_11.model.User;
import com.smarsh.spring_demo_11.support.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@Slf4j
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @TestConfiguration
    static class TestConfig {
        @Bean
        @Qualifier("userServiceImpl")
        public UserService userService() {
            return Mockito.mock(UserService.class);
        }
    }

    @Test
    public void testCreateUser() throws Exception {
        User user = new User();


        String string = user.toString();
        log.info("user: {}", string);
        log.info("from objectMapper: {}", objectMapper.writeValueAsString(user));
        mockMvc.perform(
                post("/users")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(user))).andExpect(status().isOk());

    }


}
