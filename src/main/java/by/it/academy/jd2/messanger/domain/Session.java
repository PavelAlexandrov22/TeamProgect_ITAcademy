package by.it.academy.jd2.messanger.domain;

import jakarta.servlet.http.HttpSession;

import java.util.List;
import java.util.Set;

public class Session {
    private Set<User> users;

    private List<HttpSession> httpSession;

    public Session() {
    }

    public Session(Set<User> users, List<HttpSession> httpSession) {
        this.users = users;
        this.httpSession = httpSession;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public List<HttpSession> getHttpSession() {
        return httpSession;
    }

    public void setHttpSession(List<HttpSession> httpSession) {
        this.httpSession = httpSession;
    }

    public void addSession(HttpSession httpSession){
        this.httpSession.add(httpSession);
    }
}
