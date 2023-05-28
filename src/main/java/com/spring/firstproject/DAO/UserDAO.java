package com.spring.firstproject.DAO;

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
}
