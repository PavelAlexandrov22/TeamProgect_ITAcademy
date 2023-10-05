package by.it.academy.jd2.messanger.services;

import by.it.academy.jd2.messanger.core.exeptions.ValidationException;
import by.it.academy.jd2.messanger.domain.User;
import by.it.academy.jd2.messanger.repository.api.ISessionRepo;
import by.it.academy.jd2.messanger.services.api.ILoginService;


public class LoginService implements ILoginService {

    private ISessionRepo sessionRepo;

    private final String ADMIN = "admin";

    private final String USER = "user";

    public LoginService(ISessionRepo userRepo) {
        this.sessionRepo = userRepo;
    }

    @Override
    public void login(User user) throws ValidationException {
        if (isUserContainsInDB(user.getLogin(), user.getPassword())) {
            throw new ValidationException("Такого пользователя нет в системе");
        }
        isAdmin(user);

    }

    private boolean isUserContainsInDB(String login, String password) {
        return sessionRepo.getUserByNameAndPassword(login, password) != null;
    }

    private void isAdmin(User user){
        if( user.getLogin().equals(ADMIN) && user.getPassword().equals(ADMIN)){
            user.setRole(ADMIN);
        } else {
            user.setRole(USER);
        }
    }


}

