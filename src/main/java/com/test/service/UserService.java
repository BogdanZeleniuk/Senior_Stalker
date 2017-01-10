package com.test.service;

import com.test.model.User;

import java.util.List;

public interface UserService {

    User save(User user);

    List<User> getAll();

    User getByEmail(String email);
}
