package com.test;

import com.test.dto.UserDTO;
import com.test.dto.UserUtil;
import com.test.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import static java.util.Objects.requireNonNull;

public class AuthorizedUser extends org.springframework.security.core.userdetails.User{
    private static final long serialVersionUID = 1L;

    private UserDTO userDTO;

    public AuthorizedUser(User user) {
        super(user.getEmail(), user.getPassword(), true,  true, true, true, user.getRoles());
        this.userDTO = UserUtil.userAsDTO(user);
    }

    public static AuthorizedUser safeGet() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }
        Object principal = auth.getPrincipal();
        return (principal instanceof AuthorizedUser) ? (AuthorizedUser) principal : null;
    }

    public static AuthorizedUser get() {
        AuthorizedUser user = safeGet();
        requireNonNull(user, "No authorized user found");
        return user;
    }

    @Override
    public String toString() {
        return userDTO.toString();
    }
}
