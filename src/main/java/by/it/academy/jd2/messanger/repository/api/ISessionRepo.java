package by.it.academy.jd2.messanger.repository.api;

import by.it.academy.jd2.messanger.domain.Message;
import by.it.academy.jd2.messanger.domain.User;
import jakarta.servlet.http.HttpSession;

import java.util.List;
import java.util.Set;

public interface ISessionRepo {

    Set<User> getUsersSet();
    Set<HttpSession> getActiveSession();

    Long getCountActiveSession();

    Long getCountUser();

    User getUserByName(String login, String passw);

    Long getUserId(String login, String passw);

    User getUser(Long idUser);

    void saveUser(User user);

    List<Message> getMessages(Long idUser);

    void addMessage(Long toId,  Message message);

    Long count(Long idUser);

}
