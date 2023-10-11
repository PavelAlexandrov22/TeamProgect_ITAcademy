package by.it.academy.jd2.messanger.repository.postgres;

import by.it.academy.jd2.messanger.domain.User;
import by.it.academy.jd2.messanger.repository.api.ISessionRepo;
import jakarta.servlet.http.HttpSession;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

public class DBSessionRepo implements ISessionRepo {

    private DataSource ds = DBConnection.getInstance();

    String insertQuery;

    //todo add sql requests in all methods
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

        insertQuery = new String("INSERT INTO messager.users (login, password, fio, role) VALUES (?, ?, ?, ?);");

        try (Connection con = ds.getConnection();
        PreparedStatement pst = con.prepareStatement(insertQuery)){


            pst.setString(1, user.getLogin());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getFio());
         //   pst.setDate(4, (Date) user.getBrDate());
//            pst.setDate(5, (Date) user.getSiginDate());
            pst.setString(4,user.getRole());

            pst.execute();

        } catch (SQLException e) {
            throw new RuntimeException("Ошибка записи пользователя", e);
        }
    }
}
