package by.it.academy.jd2.messanger.controller.api;
import by.it.academy.jd2.messanger.core.exeptions.ValidationException;
import by.it.academy.jd2.messanger.domain.User;
import by.it.academy.jd2.messanger.services.api.IUserService;
import by.it.academy.jd2.messanger.services.factory.UserServiceFactory;
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

    private static final Date DATE = new Date();
    private static final IUserService userService = UserServiceFactory.getInstance();



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        String login = req.getParameter(LOGIN_PARAM_NAME);
        String password = req.getParameter(PASSWORD_PARAM);
        String fio = req.getParameter(FIO);
        String users = req.getParameter("Пользователь");
        String date = req.getParameter(String.valueOf(DATE));


        //AtomicReference<User> user = new AtomicReference<>(new User());

        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setFio(fio);
        user.setRole(users);
       // user.setBrDate(date);
        user.setRole(users);

        try {
          userService.save(user);

        } catch (ValidationException e) {
            throw new RuntimeException(e);
        }


    }
}
