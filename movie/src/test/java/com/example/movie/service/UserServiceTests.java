package com.example.movie.service;

import com.example.movie.mapper.UserMapper;
import com.example.movie.model.User;
import com.example.movie.service.ex.EmailDuplicatedException;
import com.example.movie.service.ex.EmailNotExistException;
import com.example.movie.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class) //runwith: indicate to start this unit test class, SpringRunner.class: an instance
public class UserServiceTests {
    @Autowired
    private IUserService userService;
    /**
     *
     * Unit test
     * 1. must be void
     * 2. must has @Test annotation
     * has be public and has no input parameter
     */
    @Test
    public void register() {
        try {
            User user = new User();
            user.setEmail("jasonLee@email.com");
            user.setUsername("Jason Lee");
            userService.register(user);
            System.out.println("OK");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getName());
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void registerAnExistingUser() {
        try {
            User user = new User();
            user.setEmail("test1@email.com");
            user.setUsername("Bob Lee");
            userService.register(user);
        } catch (ServiceException e) {
            System.out.println(e.getClass().getName());
            System.out.println(e.getMessage());
            assert e instanceof EmailDuplicatedException;
        }
    }

    @Test
    public void getUserByEmail() {
        try {
            String email = "test1@email.com";
            User user = userService.getUserByEmail(email);
            System.out.println(user);
        } catch (ServiceException e) {
            System.out.println(e.getClass().getName());
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void getUserByNonExistEmail() {
        try {
            String email = "invalid@email.com";
            User user = userService.getUserByEmail(email);
            System.out.println(user);
        } catch (ServiceException e) {
            System.out.println(e.getClass().getName());
            System.out.println(e.getMessage());
            assert e instanceof EmailNotExistException;
        }
    }

    @Test
    public void getUserById() {
        try {
            Long id = 3L;
            User user = userService.getUserById(id);
            System.out.println(user);
        } catch (ServiceException e) {
            System.out.println(e.getClass().getName());
            System.out.println(e.getMessage());
        }
    }
}
