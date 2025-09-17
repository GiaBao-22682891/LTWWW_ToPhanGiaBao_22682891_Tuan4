package org.example.bai1_jpa.DAO.impl;


import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.bai1_jpa.DAO.UserDAO;
import org.example.bai1_jpa.Model.Enum.Gender;
import org.example.bai1_jpa.Model.User;
import org.example.bai1_jpa.Utils.JPAUtils;

import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    public EntityManager entityManager;

    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void insertUser(User user) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(user);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getUserList() {

        try (EntityManager entityManager = JPAUtils.getEntityManager()) {
            return entityManager
                    .createQuery("SELECT u from User u", User.class)
                    .getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
