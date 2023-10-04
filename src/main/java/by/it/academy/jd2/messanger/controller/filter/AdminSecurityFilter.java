package by.it.academy.jd2.messanger.controller.filter;
import by.it.academy.jd2.messanger.domain.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns =  "/admin/*")
public class AdminSecurityFilter implements Filter {

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
            resp.sendRedirect(contextPath + "/");
        }



    }
}
