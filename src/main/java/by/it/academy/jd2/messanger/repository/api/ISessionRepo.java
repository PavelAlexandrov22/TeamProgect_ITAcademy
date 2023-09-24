package by.it.academy.jd2.messanger.repository.api;

import by.it.academy.jd2.messanger.User;
import jakarta.servlet.http.HttpSession;

import java.util.List;
import java.util.Set;

public interface ISessionRepo {
    Set<User> getUsersSet();
    List<HttpSession> getActiveSession();

    Long getCountActiveSession();

    Long getCountUser();
}
