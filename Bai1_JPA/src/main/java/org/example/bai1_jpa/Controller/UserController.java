package org.example.bai1_jpa.Controller;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.bai1_jpa.DAO.UserDAO;
import org.example.bai1_jpa.DAO.impl.UserDAOImpl;
import org.example.bai1_jpa.Model.Enum.Gender;
import org.example.bai1_jpa.Model.User;
import org.example.bai1_jpa.Utils.JPAUtils;

import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(name = "userController", value = "/users")
public class UserController extends HttpServlet {
    public EntityManager entityManager = JPAUtils.getEntityManager();
    private UserDAO userDAO;

    public void init() {
        this.userDAO = new UserDAOImpl(entityManager);
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