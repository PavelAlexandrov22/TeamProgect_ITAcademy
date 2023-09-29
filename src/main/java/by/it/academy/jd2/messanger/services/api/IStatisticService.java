package by.it.academy.jd2.messanger.services.api;
import by.it.academy.jd2.messanger.domain.Message;
import by.it.academy.jd2.messanger.domain.User;
import jakarta.servlet.http.HttpSession;
import java.util.Map;

public interface IStatisticService {
    long getStatistics();

    void updateStatistic(HttpSession session);



}
