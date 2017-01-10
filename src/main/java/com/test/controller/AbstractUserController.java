package com.test.controller;

import com.test.model.User;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractUserController {

    @Autowired
    UserService service;

    public User create(User user){
        user.setId(null);
        return service.save(user);
    }

    public List<User> getAll(){
        return service.getAll();
    }

    public User getByEmail(String email){
        return service.getByEmail(email);
    }
}
