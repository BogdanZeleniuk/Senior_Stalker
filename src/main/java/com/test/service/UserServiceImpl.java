package com.test.service;

import com.test.AuthorizedUser;
import com.test.dto.UserUtil;
import com.test.model.User;
import com.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public User save(User user) {
        return repository.save(UserUtil.prepareToSave(user));
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    @Override
    public User getByEmail(String email) {
        return repository.getByEmail(email);
    }

    @Override
    public AuthorizedUser loadUserByUsername(String email) throws UsernameNotFoundException {
        User u = repository.getByEmail(email);
        if (u == null) {
            throw new UsernameNotFoundException("User " + email + " is not found");
        }
        return new AuthorizedUser(u);
    }
}
