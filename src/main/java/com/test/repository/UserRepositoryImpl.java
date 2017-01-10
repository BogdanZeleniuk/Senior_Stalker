package com.test.repository;

import com.test.model.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public User save(User user) {
        if (user.isNew()){
            entityManager.persist(user);
            return user;
        }
        return entityManager.merge(user);
    }

    @Override
    public List<User> getAll() {
        return entityManager.createNamedQuery(User.GET_ALL, User.class).getResultList();
    }

    @Override
    public User getByEmail(String email) {
        User user = null;
        try {
            user = entityManager.createNamedQuery(User.GET_BY_EMAIL, User.class).setParameter("email", email).getSingleResult();
        }
        catch (NoResultException | EmptyResultDataAccessException ignored){
        }
        return user;
    }
}
