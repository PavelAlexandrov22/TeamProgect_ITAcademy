package by.it.academy.jd2.messanger.services.api;
import jakarta.servlet.http.HttpSession;

public interface IStatisticService {
    long getStatistics();

    void updateStatistic(HttpSession session);

    long getMessageStatistic();

}