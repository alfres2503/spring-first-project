package com.spring.firstproject.DAO;

import com.spring.firstproject.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDAO implements IUserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List getAllUsers() {
        String query = "FROM User";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    @Transactional
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void delete(long id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    @Transactional
    public void registerUser(User user) {
        entityManager.merge(user);
    }
}
