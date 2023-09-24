package by.it.academy.jd2.messanger.services;

import by.it.academy.jd2.messanger.User;
import by.it.academy.jd2.messanger.core.exeptions.ValidationException;
import by.it.academy.jd2.messanger.services.api.ILoginService;

public class LoginService implements ILoginService {

    //private dao
    @Override
    public User login(String login, String password) throws ValidationException {
        //todo  if in dao user with this log & pass
        return null;
    }
}
