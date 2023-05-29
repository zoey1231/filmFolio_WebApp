package com.example.movie.service;

import com.example.movie.model.User;

public interface IUserService {
    /**
     * User signup
     * @param user
     */
    void register(User user);

    User getUserByEmail(String email);

    User getUserById(Long id);

    void updateUser(User user);
}
