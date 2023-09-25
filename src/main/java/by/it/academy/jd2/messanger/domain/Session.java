package by.it.academy.jd2.messanger.domain;

import by.it.academy.jd2.messanger.repository.UserRepo;
import by.it.academy.jd2.messanger.repository.api.IUserRepo;
import jakarta.servlet.http.HttpSession;

import java.util.Set;

public class Session {
    private Set<User> users;

    private Set<HttpSession> httpSession;

    private IUserRepo userRepo=new UserRepo();

    public Session() {
    }

    public Session(Set<User> users, Set<HttpSession> httpSession) {
        this.users = users;
        this.httpSession = httpSession;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<HttpSession> getHttpSession() {
        return httpSession;
    }

    public void setHttpSession(Set<HttpSession> httpSession) {
        this.httpSession = httpSession;
    }

    public void addSession(HttpSession httpSession){
        this.httpSession.add(httpSession);
    }


}
