package com.test.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

@NamedQueries(
        {
                @NamedQuery(name = User.GET_ALL, query = "SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.roles ORDER BY u.name"),
                @NamedQuery(name = User.GET_BY_EMAIL, query = "SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.roles WHERE u.email=:email")
        }
)
@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email", name = "email_idx")})
public class User extends NamedEntity{

    public static final String GET_ALL = "USER.GET_ALL";
    public static final String GET_BY_EMAIL = "USER.GET_BY_EMAIL";

    @Email
    @Column(name = "email", nullable = false, unique = true)
    @Size(min = 3, max = 30, message = "Email should have more than 3 letters")
    @NotEmpty(message = "Email could not be empty")
    private String email;

    @Column(name = "password", nullable = false)
    @NotEmpty(message = "Password could not be empty")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @ElementCollection(fetch = FetchType.LAZY)
    private Set<Role> roles;

    public User() {
    }

    public User(Integer id, String name, String email, String password, Role role, Role ... roles) {
        this(id,name,email,password, EnumSet.of(role,roles));
    }

    public User(Integer id, String name, String email, String password, Set<Role> roles) {
        super(id, name);
        this.email = email;
        this.password = password;
        setRoles(roles);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = CollectionUtils.isEmpty(roles) ? Collections.EMPTY_SET : EnumSet.copyOf(roles);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
