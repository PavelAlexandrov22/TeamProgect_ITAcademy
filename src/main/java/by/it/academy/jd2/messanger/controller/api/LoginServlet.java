package by.it.academy.jd2.messanger.controller.api;
import by.it.academy.jd2.messanger.core.exeptions.ValidationException;
import by.it.academy.jd2.messanger.domain.Message;
import by.it.academy.jd2.messanger.domain.User;
import by.it.academy.jd2.messanger.services.api.ILoginService;
import by.it.academy.jd2.messanger.services.api.IMessageService;
import by.it.academy.jd2.messanger.services.factory.LoginServiceFactory;
import by.it.academy.jd2.messanger.services.factory.MessageServiceFactory;
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



@WebServlet(name = "login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String FROM_ID = "fromId";
    private static final String TO_ID = "toId";
    private static final String MESSAGE_BODY = "messageBody";
    private static final String DATA = "data";
    private static final ILoginService iloginService = LoginServiceFactory.getInstance();
    private static final IMessageService messageService = MessageServiceFactory.getInstance();




    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);
        String fromId = req.getParameter(FROM_ID);
        String toId = req.getParameter(TO_ID);
        String messageBody = req.getParameter(MESSAGE_BODY);
        String data = req.getParameter(DATA);
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");


        User user = new User();
        user.setPassword(password);
        user.setLogin(login);
        try {
            user.setBrDate(df.parse(data));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Message message = new Message();
        message.setFromId(Integer.parseInt(fromId));
        message.setToId(Integer.parseInt(toId));
        message.setMessageBody(messageBody);

        try {
            iloginService.login(user);
            messageService.setMessage(message);

            HttpSession session = req.getSession();
            session.setAttribute("user", user);
        } catch (ValidationException e) {
            resp.setStatus(400);
            resp.getWriter().write(e.getMessage());
        }catch (IllegalArgumentException e){
            resp.setStatus(500);
            resp.getWriter().write(e.getMessage());
        }


    }
}
