package by.it.academy.jd2.messanger.services.api;

import by.it.academy.jd2.messanger.domain.User;
import by.it.academy.jd2.messanger.core.exeptions.ValidationException;

public interface ILoginService {

    User login(User user) throws ValidationException; //
}
