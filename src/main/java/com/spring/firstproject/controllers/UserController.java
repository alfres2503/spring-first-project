package com.spring.firstproject.controllers;

import com.spring.firstproject.DAO.IUserDAO;
import com.spring.firstproject.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserDAO userDAO;

    @RequestMapping(value = "api/users/{id}")
    public User getUser(@PathVariable long id) {
        return userDAO.getUserById(id);
    }

    @RequestMapping(value = "api/users")
    public List<User> getUsers() {
        return userDAO.getAllUsers();
    }

    @RequestMapping(value = "api/users", method = RequestMethod.POST)
    public void registerUser(@RequestBody User user) {
        userDAO.registerUser(user);
    }

    @RequestMapping(value = "user1")
    public User edit() {
        return null;
    }

    @RequestMapping(value = "api/users/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        userDAO.delete(id);
    }

    @RequestMapping(value = "user3")
    public User search() {
        return null;
    }
}
