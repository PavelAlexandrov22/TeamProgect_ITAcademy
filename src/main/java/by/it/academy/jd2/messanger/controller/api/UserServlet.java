package by.it.academy.jd2.messanger.controller.api;

import by.it.academy.jd2.messanger.domain.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;

@WebServlet(name = "userServlet", urlPatterns = "api/user")
public class UserServlet extends HttpServlet {



    private static final String LOGIN_PARAM_NAME = "login";
    private static final String PASSWORD_PARAM = "password";
    private static final String FIO = "fio";
    private static final String ROLE = "role";
    private static final Date DATE = new Date();
    private static final Long ID = 1L;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String login = req.getParameter(LOGIN_PARAM_NAME);
        String password = req.getParameter(PASSWORD_PARAM);
        String fio = req.getParameter(FIO);
        String role = req.getParameter(ROLE);

        User user = new User();





    }
}
