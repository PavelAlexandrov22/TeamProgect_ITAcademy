package by.it.academy.jd2.messanger.controller.api;
import by.it.academy.jd2.messanger.core.exeptions.ValidationException;
import by.it.academy.jd2.messanger.domain.User;
import by.it.academy.jd2.messanger.services.api.IUserService;
import by.it.academy.jd2.messanger.services.factory.UserServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.UnavailableException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;


@WebServlet(name = "userServlet", urlPatterns = "/api/user")
public class UserServlet extends HttpServlet {

    private static final String LOGIN_PARAM_NAME = "login";
    private static final String PASSWORD_PARAM = "password";
    private static final String FIO = "fio";

    private static final String DATE = "date";




    private static final IUserService userService = UserServiceFactory.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("/ui/signup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        String login = req.getParameter(LOGIN_PARAM_NAME);
        String password = req.getParameter(PASSWORD_PARAM);
        String fio = req.getParameter(FIO);
        String date = req.getParameter(DATE);
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");



        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setFio(fio);
        user.setRole("user");
        user.setSiginDate(new Date());



        try {

           // user.setBrDate(df.parse(date));
            userService.save(user);
            HttpSession session = req.getSession();
            session.setAttribute("user", user);

            if(login.equals("admin")){
                req.getRequestDispatcher("/admin/statistic").forward(req, resp);
            }else {
                req.getRequestDispatcher( "/api/chats").forward(req, resp);
            }

            req.getRequestDispatcher( "/ui/chats.jsp").forward(req,resp);

        } catch (ValidationException e) {
            resp.setStatus(400);
            resp.getWriter().write(e.getMessage());
        }catch (IllegalArgumentException e){
            resp.setStatus(500);
            resp.getWriter().write(e.getMessage());
        }
    }
}