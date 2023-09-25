package by.it.academy.jd2.messanger.repository;

import by.it.academy.jd2.messanger.domain.User;
import by.it.academy.jd2.messanger.repository.api.IMessageRepo;
import by.it.academy.jd2.messanger.repository.api.ISessionRepo;
import by.it.academy.jd2.messanger.repository.api.IUserRepo;
import jakarta.servlet.http.HttpSession;

import java.util.*;

public class SessionRepo implements ISessionRepo {

    private Set<User> users = Collections.synchronizedSet(new HashSet<>());

    private Set<HttpSession> sessions = Collections.synchronizedSet(new HashSet<>());


    @Override
    public Set<User> getUsersSet() {
        return this.users;
    }

    @Override
    public Set<HttpSession> getActiveSession() {
        return this.sessions;
    }

    @Override
    public Long getCountActiveSession() {
        return (long) this.sessions.size();
    }

    @Override
    public Long getCountUser() {
        return (long) this.users.size();
    }

    @Override
    public User getUserByName(String login, String passw) {
        return this.users.stream().filter(user -> user.getLogin().equals(login) && user.getPassword().equals(passw)).findFirst().get();
    }

    @Override
    public Long getUserId(String login, String passw) {
        User user = getUserByName(login, passw);
        return user == null ? null : user.getId();
    }


}
