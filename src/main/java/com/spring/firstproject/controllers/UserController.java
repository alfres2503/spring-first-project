package com.spring.firstproject.controllers;

import com.spring.firstproject.DAO.IUserDAO;
import com.spring.firstproject.DAO.UserDAO;
import com.spring.firstproject.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserDAO userDAO;
    @RequestMapping(value = "user/{id}")
    public User getUser(@PathVariable long id) {
        User user = new User();

        user.setId(id);
        user.setName("Juan");
        user.setLast_name("Perez");
        user.setEmail("JuanP@mail.com");
        user.setPhone("81234567");

        return user;
    }

    @RequestMapping(value = "users")
    public List<User> getUsers() {
        List<User> users = userDAO.getAllUsers();
        return users;
    }

    @RequestMapping(value = "user1")
    public User edit() {
        User user = new User();

        user.setName("Juan");
        user.setLast_name("Perez");
        user.setEmail("JuanP@mail.com");
        user.setPhone("81234567");

        return user;
    }

    @RequestMapping(value = "user2")
    public User delete() {
        User user = new User();

        user.setName("Juan");
        user.setLast_name("Perez");
        user.setEmail("JuanP@mail.com");
        user.setPhone("81234567");

        return user;
    }

    @RequestMapping(value = "user3")
    public User search() {
        User user = new User();

        user.setName("Juan");
        user.setLast_name("Perez");
        user.setEmail("JuanP@mail.com");
        user.setPhone("81234567");

        return user;
    }
}
