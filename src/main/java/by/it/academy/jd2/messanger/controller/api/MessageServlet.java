package by.it.academy.jd2.messanger.controller.api;

import by.it.academy.jd2.messanger.core.exeptions.ValidationException;
import by.it.academy.jd2.messanger.domain.Message;
import by.it.academy.jd2.messanger.domain.User;
import by.it.academy.jd2.messanger.services.api.IMessageService;
import by.it.academy.jd2.messanger.services.factory.MessageServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "message", urlPatterns = "/user/message")
public class MessageServlet extends HttpServlet {

    private IMessageService messageService = MessageServiceFactory.getInstance();

    private static final String MESSAGE_BODY = "messageBody";

    private static final int TO_ID = 0;




    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();


      //  writer.write(messageService.getMessage());


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        String messageBody = req.getParameter(MESSAGE_BODY);
        String toId = req.getParameter(String.valueOf(TO_ID));

        Message message = new Message();
        message.setMessageBody(messageBody);
        message.setToId(Integer.parseInt(toId));

        try {
            messageService.setMessage(message);
        } catch (ValidationException e) {
            resp.setStatus(400);
            resp.getWriter().write(e.getMessage());
        }catch (IllegalArgumentException e){
            resp.setStatus(500);
            resp.getWriter().write(e.getMessage());
        }


    }
}
