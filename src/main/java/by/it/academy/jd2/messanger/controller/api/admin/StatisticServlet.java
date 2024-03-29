package by.it.academy.jd2.messanger.controller.api.admin;
import by.it.academy.jd2.messanger.services.api.IStatisticService;
import by.it.academy.jd2.messanger.services.factory.StatisticServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;


@WebServlet(name = "statistic", urlPatterns = "/admin/statistic")
public class StatisticServlet extends HttpServlet {
    private IStatisticService statisticService = StatisticServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        req.setCharacterEncoding("UTF-8");


        if (Optional.ofNullable(req.getParameter("user")).isPresent()) {
            String login = req.getParameter("user");
            if (login.equals("admin")) {
                req.setAttribute("session",statisticService.getStatistics());
                req.setAttribute("messages",statisticService.getMessageStatistic());
                req.getRequestDispatcher("/admin/statistic").forward(req, resp);
            } else {
                resp.sendRedirect(req.getContextPath() + "/api/chats");
            }
        } else {
            req.getRequestDispatcher("/login").forward(req, resp);
        }

    }



}

