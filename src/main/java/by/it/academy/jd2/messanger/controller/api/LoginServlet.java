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
import java.io.IOException;
import java.util.Date;


@WebServlet(name = "login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final int FROM_ID = 0;
    private static final int TO_ID = 0;
    private static final String MESSAGE_BODY = "messageBody";
    private static final Date DATE = new Date();
    private static final ILoginService iloginService = LoginServiceFactory.getInstance();
    private static final IMessageService messageService = MessageServiceFactory.getInstance();




    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);
        String fromId = req.getParameter(String.valueOf(FROM_ID));
        String toId = req.getParameter(String.valueOf(TO_ID));
        String messageBody = req.getParameter(MESSAGE_BODY);
        String data = req.getParameter(String.valueOf(DATE));


        User user = new User();
        user.setPassword(password);
        user.setLogin(login);
        //user.setBrDate(data);
        Message message = new Message();
        message.setFromId(Integer.parseInt(fromId));
        message.setToId(Integer.parseInt(toId));
        message.setMessageBody(messageBody);


        try {
            iloginService.login(user);
            messageService.setMessage(message);
        } catch (ValidationException e) {
            throw new RuntimeException(e);
        }


    }
}
