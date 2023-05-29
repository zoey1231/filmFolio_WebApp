package com.example.movie.service.impl;

import com.example.movie.mapper.UserMapper;
import com.example.movie.model.User;
import com.example.movie.service.IUserService;
import com.example.movie.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void register(User user) {
        String email = user.getEmail();
        User result = userMapper.findByEmail(email);
        if (result != null) {
            throw new EmailDuplicatedException("The email already exists");
        }
        //filling joinedDate
        Date date = new Date();
        user.setJoinedDate(date);
        user.setToWatchCount(0);
        user.setTotalWatchedCount(0);
        Integer numOfRows = userMapper.insert(user);
        if (numOfRows != 1) {
            throw new InsertException("Insert user data failed");
        }
    }

    @Override
    public User getUserByEmail(String email) {
        User result = userMapper.findByEmail(email);
        if (result == null) {
            throw new EmailNotExistException("The email does not exist");
        }
        return result;
    }

    @Override
    public User getUserById(Long id) {
        User result = userMapper.findById(id);
        if (result == null) {
            throw new UserIdNotExistException("The email does not exist");
        }
        return result;
    }

    @Override
    public void updateUser(User user) {
        Integer numOfRows = userMapper.update(user);
        if (numOfRows != 1) {
            throw new UpdateException("Update user data failed");
        }
    }
}
