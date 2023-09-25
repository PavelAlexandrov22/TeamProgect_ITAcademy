package by.it.academy.jd2.messanger.services.api;

import by.it.academy.jd2.messanger.domain.User;
import by.it.academy.jd2.messanger.core.exeptions.ValidationException;

public interface IUserService {
    void save(User user) throws ValidationException;
}
