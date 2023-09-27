package by.it.academy.jd2.messanger.services;

import by.it.academy.jd2.messanger.core.exeptions.ValidationException;
import by.it.academy.jd2.messanger.domain.User;
import by.it.academy.jd2.messanger.repository.api.ISessionRepo;
import by.it.academy.jd2.messanger.services.api.ILoginService;


public class LoginService implements ILoginService {

    private ISessionRepo sessionRepo;

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
        return sessionRepo.getUserByName(login, password) != null;
    }

    private boolean isAdmin(User user){
        if( user.getLogin().equals("admin") && user.getPassword().equals("admin")){
            user.setRole("admin");
            return true;
        } else {
            user.setRole("user");
            return false;
        }
    }
}


