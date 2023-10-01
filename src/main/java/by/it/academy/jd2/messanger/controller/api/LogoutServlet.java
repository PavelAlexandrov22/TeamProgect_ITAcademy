package by.it.academy.jd2.messanger.controller.api;

import by.it.academy.jd2.messanger.services.api.IUserService;
import by.it.academy.jd2.messanger.services.factory.UserServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@WebServlet(name = "logoutUser", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {

    IUserService userService= UserServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");


        String login = req.getSession().getAttribute("name").toString();

        if (Optional.ofNullable(login).isPresent()){
            userService.logout(login);
            req.removeAttribute("user");
        }

        req.getRequestDispatcher("/login").forward(req,resp);
    }
}