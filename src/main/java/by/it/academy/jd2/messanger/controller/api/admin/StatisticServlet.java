package by.it.academy.jd2.messanger.controller.api.admin;
import by.it.academy.jd2.messanger.controller.listener.UserListener;
import by.it.academy.jd2.messanger.services.api.IStatisticService;
import by.it.academy.jd2.messanger.services.factory.StatisticServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



@WebServlet(name = "statistic", urlPatterns = "/admin/statistic")
public class StatisticServlet extends HttpServlet {
    private IStatisticService iStatistic = StatisticServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        long countActiveUser = UserListener.getActiveUsers();

        PrintWriter writer = resp.getWriter();
        writer.write("<p> Количество " + countActiveUser + "</p>");
    }












    }

