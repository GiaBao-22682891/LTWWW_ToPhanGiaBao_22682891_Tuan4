package org.example.bai1_jpa.DAO;


import org.example.bai1_jpa.Model.User;

import java.util.List;

public interface UserDAO {
    public void insertUser(User user);

    public List<User> getUserList ();
}
