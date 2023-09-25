package by.it.academy.jd2.messanger.repository.api;

import by.it.academy.jd2.messanger.domain.User;

public interface IUserRepo {
    User getUser(int idUser);

    void saveUser(User user);
}
