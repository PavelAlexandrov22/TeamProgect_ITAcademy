package by.it.academy.jd2.messanger.repository;

import by.it.academy.jd2.messanger.domain.User;
import by.it.academy.jd2.messanger.repository.api.IUserRepo;

import java.util.Set;

public class UserRepo implements IUserRepo {

    @Override
    public User getUser(Long idUser, Set<User> usersSet) {
       return usersSet.stream().filter(user -> user.getId().equals(idUser)).findFirst().get();
    }

    @Override
    public void saveUser(User user, Set<User> usersSet) {
        usersSet.add(user);
    }

    @Override
    public User getUserByName(String login, String passw, Set<User> users) {
        return users.stream().filter(user -> user.getLogin().equals(login) && user.getPassword().equals(passw)).findFirst().get();
    }

    @Override
    public Long getUserId(String login, String passw, Set<User> users) {
        User user = getUserByName(login, passw,users);
        return user == null ? null : user.getId();
    }
}
