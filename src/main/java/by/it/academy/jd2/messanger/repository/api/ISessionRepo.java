package by.it.academy.jd2.messanger.repository.api;
import by.it.academy.jd2.messanger.domain.User;
import jakarta.servlet.http.HttpSession;
import java.util.Set;

public interface ISessionRepo {

    Set<User> getUsersSet();
    Set<HttpSession> getActiveSession();

    Long getCountActiveSession();

    Long getCountUser();

    User getUserByNameAndPassword(String login, String passw);
    User getUserByName(String login);

    User getUserByLogin(String  login);

    Long getUserId(String login, String passw);

    User getUser(Long idUser);

    void saveUser(User user);



}