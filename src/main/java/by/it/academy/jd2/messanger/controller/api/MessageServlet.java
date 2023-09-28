package by.it.academy.jd2.messanger.controller.api;
import by.it.academy.jd2.messanger.core.exeptions.ValidationException;
import by.it.academy.jd2.messanger.domain.Message;
import by.it.academy.jd2.messanger.services.api.IMessageService;
import by.it.academy.jd2.messanger.services.factory.MessageServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "message", urlPatterns = "/user/message")
public class MessageServlet extends HttpServlet {

    private IMessageService messageService = MessageServiceFactory.getInstance();

    private static final String MESSAGE_BODY = "messageBody";

    private static final String TO_ID = "toId";




    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        PrintWriter writer = resp.getWriter();


       // writer.write(messageService.getMessage());


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        String messageBody = req.getParameter(MESSAGE_BODY);
        String toId = req.getParameter(TO_ID);

        Message message = new Message();
        message.setMessageBody(messageBody);
        message.setToId(Integer.parseInt(toId));

        try {
            messageService.setMessage(message);
            HttpSession session = req.getSession();
            session.setAttribute("message", message);
        } catch (ValidationException e) {
            resp.setStatus(400);
            resp.getWriter().write(e.getMessage());
        }catch (IllegalArgumentException e){
            resp.setStatus(500);
            resp.getWriter().write(e.getMessage());
        }


    }
}
