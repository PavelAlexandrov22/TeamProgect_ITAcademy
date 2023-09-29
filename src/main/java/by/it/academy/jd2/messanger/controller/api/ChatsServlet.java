package by.it.academy.jd2.messanger.controller.api;

import by.it.academy.jd2.messanger.core.exeptions.ValidationException;
import by.it.academy.jd2.messanger.domain.Message;
import by.it.academy.jd2.messanger.services.api.IMessageService;
import by.it.academy.jd2.messanger.services.api.IUserService;
import by.it.academy.jd2.messanger.services.factory.MessageServiceFactory;
import by.it.academy.jd2.messanger.services.factory.UserServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@WebServlet(name = "chat", urlPatterns = "/api/chats")
public class ChatsServlet extends HttpServlet {
    private static final IMessageService messageService= MessageServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        if(Optional.ofNullable(req.getSession().getAttribute("user")).isPresent()){
            String login=req.getSession().getAttribute("user").toString();
            try {
                Map<String,Message> chat=messageService.getChat(login);
                req.setAttribute("chat",chat);
                req.getRequestDispatcher("/ui/chats.jsp").forward(req,resp);
            } catch (ValidationException e) {
                resp.setStatus(400);
                resp.getWriter().write(e.getMessage());
            }
        }else{
            resp.setStatus(401);
        }



    }
}
