package com.example.bai1.DAO;

import com.example.bai1.Model.User;

import java.util.List;

public interface UserDAO {
    public void insertUser(User user);

    public List<User> getUserList ();
}
