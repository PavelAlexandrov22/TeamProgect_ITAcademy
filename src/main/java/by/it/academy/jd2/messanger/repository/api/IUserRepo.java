package by.it.academy.jd2.messanger.repository.api;

import by.it.academy.jd2.messanger.domain.User;

import java.util.Set;

public interface IUserRepo {
    User getUser(Long idUser, Set<User> usersSet);

    void saveUser(User user,Set<User> usersSet);
}
