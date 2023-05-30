package com.spring.firstproject.DAO;

import com.spring.firstproject.models.User;

import java.util.List;

public interface IUserDAO {
    List<User> getAllUsers();

    User getUserById(long id);

    void delete(long id);

    void registerUser(User user);
}
