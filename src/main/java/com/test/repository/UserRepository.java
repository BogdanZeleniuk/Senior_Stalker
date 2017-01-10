package com.test.repository;

import com.test.model.User;

public interface UserRepository {

    User save(User user);

    User getByEmail(String email);
}
