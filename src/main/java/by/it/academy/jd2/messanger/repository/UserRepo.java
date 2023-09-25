package by.it.academy.jd2.messanger.repository;

import by.it.academy.jd2.messanger.domain.User;
import by.it.academy.jd2.messanger.repository.api.IUserRepo;

import java.util.Set;

public class UserRepo implements IUserRepo {

    private Long id=0L;

    @Override
    public User addIdforUser(User user) {
        user.setId(id);
        id++;
        return user;
    }


}
