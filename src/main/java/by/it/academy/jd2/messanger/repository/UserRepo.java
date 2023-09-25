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
}
