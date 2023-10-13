package by.it.academy.jd2.messanger.controller.filter;
import by.it.academy.jd2.messanger.core.exeptions.ValidationException;
import by.it.academy.jd2.messanger.domain.User;
import by.it.academy.jd2.messanger.services.api.IMessageService;
import by.it.academy.jd2.messanger.services.api.IUserService;
import by.it.academy.jd2.messanger.services.factory.MessageServiceFactory;
import by.it.academy.jd2.messanger.services.factory.UserServiceFactory;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns =  "/admin/*")
public class AdminSecurityFilter implements Filter {

    private final IUserService userService = UserServiceFactory.getInstance();
    private final IMessageService messageService = MessageServiceFactory.getInstance();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String contextPath = req.getContextPath();
        HttpSession session = req.getSession();

        if((session != null) && (session.getAttribute("user") != null) ){
            User user = (User) session.getAttribute("user");
            user.setRole("admin");
            if(user.getRole().equals("admin")){
                chain.doFilter(request, response);
            }
        }else{
            if(!messageService.isUserInSystem("admin")){
                try {
                    userService.save(new User("admin", "admin",
                            null, null, null, "admin"));
                    chain.doFilter(request, response);
                } catch (ValidationException e) {
                    throw new RuntimeException(e);
                }

            }
            resp.sendRedirect(contextPath + "/");
        }



    }
}
