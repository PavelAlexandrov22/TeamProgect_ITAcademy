package by.it.academy.jd2.messanger.repository;


import by.it.academy.jd2.messanger.domain.User;
import by.it.academy.jd2.messanger.repository.api.ISessionRepo;
import by.it.academy.jd2.messanger.repository.api.IUserRepo;
import jakarta.servlet.http.HttpSession;

import java.util.*;

public class SessionRepo implements ISessionRepo {

    private final IUserRepo userRepo;

    public SessionRepo(IUserRepo userRepo) {

        this.userRepo = userRepo;
    }

    private Set<User> users = Collections.synchronizedSet(new HashSet<>());

    private Set<HttpSession> sessions = Collections.synchronizedSet(new HashSet<>());

    /**
     * this method give you all users set, just for looking(reading);
     */
    @Override
    public Set<User> getUsersSet() {
        return this.users;
    }


    /**
     * this method give you all session set, just for looking(reading);
     */
    @Override
    public Set<HttpSession> getActiveSession() {
        return this.sessions;
    }

    /**
     * this method give you count of active session for statistics,
     * if you want, do it yourself from getActiveSession() method
     * and get size from Sessions set
     */
    @Override
    public Long getCountActiveSession() {
        return (long) this.sessions.size();
    }

    /**
     * this method give you count of active session for statistics,
     * if you want, do it yourself from getUsersSet() method
     * and get size from Users set
     */
    @Override
    public Long getCountUser() {
        return (long) this.users.size();
    }

    /**
     * @param login login
     * @param passw password
     * @return user
     * method for taken Users entity (Example for validation)
     * return maybe nullable
     */
    @Override
    public User getUserByName(String login, String passw) {
        return this.users.stream().filter(user -> user.getLogin().equals(login) && user.getPassword().equals(passw)).findFirst().get();
    }

    @Override
    public User getUserByLogin(String  login){
        return this.users.stream().filter(user -> user.getLogin().equals(login)).findFirst().get();
    }

    /**
     * @param login login
     * @param passw password
     * @return Long
     * method give you id of user
     * return maybe nullable
     */
    @Override
    public Long getUserId(String login, String passw) {
        User user = getUserByName(login, passw);
        return user == null ? null : user.getId();
    }

    /**
     * @param idUser users id
     * @return User
     * method give you Users entity by id
     */
    public User getUser(Long idUser) {
        return this.users.stream().filter(user -> user.getId().equals(idUser)).findFirst().get();
    }

    /**
     * @param user user to save
     * method save User to result set of Users
     */
    @Override
    public void saveUser(User user) {
        synchronized (this) {
            this.users.add(userRepo.addIdforUser(user));
        }
    }

}
