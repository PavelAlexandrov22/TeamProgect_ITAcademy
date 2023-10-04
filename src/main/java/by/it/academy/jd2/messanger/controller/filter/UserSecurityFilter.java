package by.it.academy.jd2.messanger.controller.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Optional;
import java.io.IOException;

@WebFilter( urlPatterns = "/api/message")




public class UserSecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String contextPath = req.getContextPath();
        HttpSession session = req.getSession();
        if((session.isNew()) && Optional.ofNullable(req.getSession().getAttribute("user")).isPresent()){
            chain.doFilter(request, response);

        }else {
            resp.sendRedirect(contextPath + "/api/chats");

        }

    }
}
