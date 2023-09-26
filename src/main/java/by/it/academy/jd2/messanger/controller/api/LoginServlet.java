package by.it.academy.jd2.messanger.controller.api;

import by.it.academy.jd2.messanger.core.exeptions.ValidationException;
import by.it.academy.jd2.messanger.domain.User;
import by.it.academy.jd2.messanger.repository.api.IMessageRepo;
import by.it.academy.jd2.messanger.repository.factory.MessageRepoFactory;
import by.it.academy.jd2.messanger.services.UserService;
import by.it.academy.jd2.messanger.services.api.IUserService;
import by.it.academy.jd2.messanger.services.factory.UserServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";


    private static final IUserService iUserServ = UserServiceFactory.getInstance();
    private static final IMessageRepo iMess = MessageRepoFactory.getInstance();



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);
        User user = new User();

        user.setPassword(password);
        user.setLogin(login);

        try {
            iUserServ.save(user);
        } catch (ValidationException e) {
            throw new RuntimeException(e);
        }


    }
}
