package com.example.movie.mapper;

import com.example.movie.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class) //runwith: indicate to start this unit test class, SpringRunner.class: an instance
public class UserMapperTests {
    @Autowired
    private UserMapper userMapper;
    /**
     *
     * Unit test
     * 1. must be void
     * 2. must has @Test annotation
     * has be public and has no input parameter
     */
    @Test
    public void insert() {
        User user = new User();
        user.setEmail("test1@email.com");
        user.setUsername("Bob Lee");
        Integer rows = userMapper.insert(user);
        System.out.println("insert rows: \n" + rows);
    }

    @Test
    public void findByEmail() {
        String email = "test1@email.com";
        User user = userMapper.findByEmail(email);
        System.out.println("find by email: \n" + user);
    }

    @Test
    public void findById() {
        Long id = 3L;
        User user = userMapper.findById(id);
        System.out.println("find by id: \n" + user);
    }
}
