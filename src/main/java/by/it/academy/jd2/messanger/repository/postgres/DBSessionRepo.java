package by.it.academy.jd2.messanger.repository.postgres;

import by.it.academy.jd2.messanger.domain.User;
import by.it.academy.jd2.messanger.repository.api.ISessionRepo;
import jakarta.servlet.http.HttpSession;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.util.*;

public class DBSessionRepo implements ISessionRepo {

    private final DataSource ds = DBConnection.getInstance();

    private String insertQuery;



    @Override
    public Set<User> getUsersSet() {
        insertQuery = new String("select id, login, password, fio," +
                " birth_date, sign_in_date, role from messager.users;");

        try (Connection con = ds.getConnection();
             PreparedStatement pst = con.prepareStatement(insertQuery)) {

            try (ResultSet rs = pst.executeQuery();) {
                Set<User> data = new HashSet<>();
                while (rs.next()) {
                    data.add(map(rs));
                }
                return data;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
        insertQuery = new String("SELECT COUNT(*) FROM messager.users;");

        try (Connection con = ds.getConnection();
             PreparedStatement pst = con.prepareStatement(insertQuery)) {

            ResultSet resultSet = pst.executeQuery();

            if (resultSet.next()) {
                return resultSet.getLong(1);
            } else {
                throw new RuntimeException("Не получилось получить количество пользователей из системы");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка пожключения к базе ", e);
        }
    }

    @Override
    public User getUserByNameAndPassword(String login, String passw) {
        insertQuery = new String("select id, fio, birth_date," +
                " sign_in_date, role from messager.users\n" +
                "where login = ? AND password = ?;");

        try (Connection con = ds.getConnection();
             PreparedStatement pst = con.prepareStatement(insertQuery)) {

            pst.setString(1, login);
            pst.setString(2, passw);
            ResultSet resultSet = pst.executeQuery();

            if (resultSet.next()) {
                User user = new User();

                Long id = resultSet.getLong("id");
                user.setId(id);

                user.setLogin(login); //because we have login in param


                user.setPassword(passw); //because we have password in param

                String fio = resultSet.getString("fio");
                user.setFio(fio);

                Date birthDate = resultSet.getDate("birth_date");
                user.setBrDate(birthDate);

                Date sighInDate = resultSet.getDate("sign_in_date");
                user.setSiginDate(sighInDate);

                String role = resultSet.getString("role");
                user.setRole(role);

                return user;
            } else {
                throw new RuntimeException("Пользователь не найден");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка подключения к базе", e);
        }
    }

    @Override
    public User getUserByName(String login) {
        return null; //same method like getUserByLogin(String login) don`t realize
    }

    @Override
    public User getUserByLogin(String login) {
        insertQuery = new String("select id, password, fio, birth_date," +
                " sign_in_date, role from messager.users\n" +
                "where login = ?;");

        try (Connection con = ds.getConnection();
             PreparedStatement pst = con.prepareStatement(insertQuery)) {

            pst.setString(1, login);
            ResultSet resultSet = pst.executeQuery();

            if (resultSet.next()) {
                User user = new User();

                Long id = resultSet.getLong("id");
                user.setId(id);

                user.setLogin(login); //because we have login in param

                String password = resultSet.getString("password");
                user.setPassword(password);

                String fio = resultSet.getString("fio");
                user.setFio(fio);

                Date birthDate = resultSet.getDate("birth_date");
                user.setBrDate(birthDate);

                Date sighInDate = resultSet.getDate("sign_in_date");
                user.setSiginDate(sighInDate);

                String role = resultSet.getString("role");
                user.setRole(role);

                return user;
            } else {
                throw new RuntimeException("Пользователь не найден");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка подключения к базе", e);
        }
    }

    @Override
    public Long getUserId(String login, String passw) {
        insertQuery = new String("select id from messager.users\n" +
                "where login = ? AND password = ?;");

        try (Connection con = ds.getConnection();
             PreparedStatement pst = con.prepareStatement(insertQuery)) {

            pst.setString(1, login);
            pst.setString(2, passw);

            ResultSet resultSet = pst.executeQuery();

            if (resultSet.next()) {
                return resultSet.getLong("id");

            } else {
                throw new RuntimeException("Id пользователя не найдено");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Ошибка подключени к базе", e);
        }
    }

    @Override
    public User getUser(Long idUser) {
        insertQuery = new String("select login, password, fio, birth_date," +
                " sign_in_date, role from messager.users\n" +
                "where id = ?;");

        try (Connection con = ds.getConnection();
             PreparedStatement pst = con.prepareStatement(insertQuery)) {

            pst.setString(1, String.valueOf(idUser));
            ResultSet resultSet = pst.executeQuery();

            if (resultSet.next()) {
                User user = new User();

                String login = resultSet.getString("login");
                user.setLogin(login);

                String password = resultSet.getString("password");
                user.setPassword(password);

                String fio = resultSet.getString("fio");
                user.setFio(fio);

                Date birthDate = resultSet.getDate("birth_date");
                user.setBrDate(birthDate);

                Date sighInDate = resultSet.getDate("sign_in_date");
                user.setSiginDate(sighInDate);

                String role = resultSet.getString("role");
                user.setRole(role);

                return user;
            } else {
                throw new RuntimeException("Пользователь не найден");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка подключения к базе", e);
        }

    }

    @Override
    public void saveUser(User user) {

        insertQuery = new String("INSERT INTO messager.users (login, password, fio, birth_date, sign_in_date, role) VALUES (?, ?, ?, ?, ?, ?);");

        try (Connection con = ds.getConnection();
             PreparedStatement pst = con.prepareStatement(insertQuery)) {


            pst.setString(1, user.getLogin());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getFio());
            pst.setDate(4, new java.sql.Date(user.getBrDate().getTime()));
            pst.setDate(5, new java.sql.Date(user.getSiginDate().getTime()));
            pst.setString(6, user.getRole());

            pst.execute();

        } catch (SQLException e) {
            throw new RuntimeException("Ошибка подключения к базе", e);
        }
    }

    private User map(ResultSet rs) throws SQLException {

        User item = new User();
        item.setId(rs.getLong("id"));
        item.setLogin(rs.getString("login"));
        item.setPassword(rs.getString("password"));
        item.setFio(rs.getString("fio"));
        item.setBrDate(rs.getDate("birth_date"));
        item.setSiginDate(rs.getDate("sign_in_date"));
        item.setRole(rs.getString("role"));

        return item;
    }
}