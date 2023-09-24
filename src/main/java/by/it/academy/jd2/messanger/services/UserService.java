package by.it.academy.jd2.messanger.services;

import by.it.academy.jd2.messanger.User;
import by.it.academy.jd2.messanger.core.exeptions.ValidationException;
import by.it.academy.jd2.messanger.services.api.IUserService;

public class UserService implements IUserService {

    // private Dao
    @Override
    public void save(User user) throws ValidationException {
        //todo save in dao
    }
}
