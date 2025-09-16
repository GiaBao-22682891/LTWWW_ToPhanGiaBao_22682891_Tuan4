package com.example.bai1.DAO.impl;

import com.example.bai1.DAO.UserDAO;
import com.example.bai1.Model.Enum.Gender;
import com.example.bai1.Model.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private final DataSource dataSource;

    public UserDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public void insertUser(User user) {
        String sql = "insert into user (first_name, last_name, email, password, birthday, gender) values (?,?,?,?,?,?)";
        try (Connection conn = (Connection) dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getBirthday());
            ps.setString(6, user.getGender().toString());
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getUserList() {
        String sql = "select * from user";
        List<User> userList = new ArrayList<>();

        try (Connection conn = (Connection) this.dataSource.getConnection();
             PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String birthday = rs.getString("birthday");
                Gender gender = Gender.valueOf(rs.getString("gender"));

                userList.add(new User(id, firstName, lastName, email, password, birthday, gender));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
}
