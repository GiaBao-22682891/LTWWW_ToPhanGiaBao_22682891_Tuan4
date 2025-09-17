package com.example.bai1.Controller;

import java.io.*;

import com.example.bai1.DAO.UserDAO;
import com.example.bai1.DAO.impl.UserDAOImpl;
import com.example.bai1.Model.Enum.Gender;
import com.example.bai1.Model.User;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.sql.DataSource;

@WebServlet(name = "userController", value = "/users")
public class UserController extends HttpServlet {
    @Resource(name = "jdbc/userds")
    private DataSource dataSource;

    private UserDAO userDAO;

    public void init() {
        this.userDAO = new UserDAOImpl(this.dataSource);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("register-form.jsp").forward(request, response); // request từ trang j...
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String birthday = req.getParameter("month") + "/" + req.getParameter("day") + "/" + req.getParameter("year") ;
        Gender gender = Gender.valueOf(req.getParameter("gender"));

        User user = new User();
        user = User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .birthday(birthday)
                .gender(gender)
                .build();

        userDAO.insertUser(user);
        req.setAttribute("userList", userDAO.getUserList()); //"userList" đưa qua user-list.jsp, vế sau là áp dụng method
        req.getRequestDispatcher("user-list.jsp").forward(req, resp);
    }

    public void destroy() {
    }
}