package com.example.movie.mapper;

import com.example.movie.model.User;

//mapper in mybatis is used to map the sql query to the java method
//this is the interface for the user mapper

public interface UserMapper {
    /**
     * Insert user data into the database
     *
     * @param user
     * @return the number of rows affected(add/delete/update all have this return value)
     */
    Integer insert(User user);

    /**
     * Find the user by email
     *
     * @param email
     * @return the user data if found, null if not found
     */
    User findByEmail(String email);

    /**
     * Find the user by id
     *
     * @param id
     * @return the user data if found, null if not found
     */
    User findById(Long id);

    /**
     * Update the user data
     * @param user
     * @return the number of rows affected
     */
    Integer update(User user);


}

