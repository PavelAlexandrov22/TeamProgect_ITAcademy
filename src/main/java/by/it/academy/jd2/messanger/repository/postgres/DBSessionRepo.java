package by.it.academy.jd2.messanger.repository.postgres;

import by.it.academy.jd2.messanger.domain.User;
import by.it.academy.jd2.messanger.repository.DBConnection;
import by.it.academy.jd2.messanger.repository.api.ISessionRepo;
import jakarta.servlet.http.HttpSession;

import javax.sql.DataSource;
import java.util.Set;

public class DBSessionRepo implements ISessionRepo {

    private DataSource ds = DBConnection.getInstance();

    //todo add sql requests in all class
    @Override
    public Set<User> getUsersSet() {
        return null;
    }

    @Override
    public Set<HttpSession> getActiveSession() {
        return null;
    }

    @Override
    public Long getCountActiveSession() {
        return null;
    }

    @Override
    public Long getCountUser() {
        return null;
    }

    @Override
    public User getUserByNameAndPassword(String login, String passw) {
        return null;
    }

    @Override
    public User getUserByName(String login) {
        return null;
    }

    @Override
    public User getUserByLogin(String login) {
        return null;
    }

    @Override
    public Long getUserId(String login, String passw) {
        return null;
    }

    @Override
    public User getUser(Long idUser) {
        return null;
    }

    @Override
    public void saveUser(User user) {

    }
}
