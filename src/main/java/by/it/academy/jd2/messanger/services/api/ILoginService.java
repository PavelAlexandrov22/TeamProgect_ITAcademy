package by.it.academy.jd2.messanger.services.api;

import by.it.academy.jd2.messanger.User;
import by.it.academy.jd2.messanger.core.exeptions.ValidationException;

public interface ILoginService {

    User login(String login, String password) throws ValidationException; //
}
