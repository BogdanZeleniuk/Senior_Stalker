package com.test.repository;

import com.test.model.User;

import java.util.List;

public interface UserRepository {

    User save(User user);

    List<User> getAll();

    User getByEmail(String email);
}
