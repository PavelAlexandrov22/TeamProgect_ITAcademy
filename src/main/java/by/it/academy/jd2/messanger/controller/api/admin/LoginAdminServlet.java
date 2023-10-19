package by.it.academy.jd2.messanger.controller.api.admin;

import by.it.academy.jd2.messanger.core.exeptions.ValidationException;
import by.it.academy.jd2.messanger.domain.User;
import by.it.academy.jd2.messanger.services.api.IUserService;
import by.it.academy.jd2.messanger.services.factory.UserServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet(name = "loginAdmin", urlPatterns = "/admin/login")
public class LoginAdminServlet extends HttpServlet {
    private static final String LOGIN_PARAM_NAME = "login";
    private static final String PASSWORD_PARAM = "password";
    private static final String FIO = "fio";
    private static final String ROLE = "admin";

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
        String role = req.getParameter(ROLE);
        String date = req.getParameter(DATE);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setFio(fio);
        user.setRole(role);
        user.setSiginDate(new Date());

        try {
            Date data = df.parse(date);
            user.setBrDate(data);

            userService.save(user);
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            if(role.equals("admin")){
                req.getRequestDispatcher("/admin/statistic").forward(req, resp);
            }else {
                resp.sendRedirect(req.getContextPath() + "/api/chats");
            }
        } catch (ValidationException e ) {
            resp.setStatus(400);
            resp.getWriter().write(e.getMessage());
        }catch (IllegalArgumentException e){
            resp.setStatus(500);
            resp.getWriter().write(e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}