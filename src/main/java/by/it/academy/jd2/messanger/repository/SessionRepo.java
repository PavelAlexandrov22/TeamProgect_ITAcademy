package by.it.academy.jd2.messanger.repository;

import by.it.academy.jd2.messanger.User;
import by.it.academy.jd2.messanger.repository.api.ISessionRepo;
import jakarta.servlet.http.HttpSession;

import java.util.List;
import java.util.Set;

public class SessionRepo implements ISessionRepo {


    @Override
    public Set<User> getUsersSet() {
        return null;
    }

    @Override
    public List<HttpSession> getActiveSession() {
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
}
