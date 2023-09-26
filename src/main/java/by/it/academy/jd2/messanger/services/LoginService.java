package by.it.academy.jd2.messanger.services;

import by.it.academy.jd2.messanger.core.exeptions.ValidationException;
import by.it.academy.jd2.messanger.domain.Session;
import by.it.academy.jd2.messanger.domain.User;
import by.it.academy.jd2.messanger.repository.api.ISessionRepo;
import by.it.academy.jd2.messanger.services.api.ILoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

public class LoginService implements ILoginService {

    private ISessionRepo sessionRepo;

    public LoginService(ISessionRepo userRepo) {
        this.sessionRepo = userRepo;
    }

    @Override
    public void login(User user, HttpServletRequest req, HttpServletResponse resp) throws ValidationException {
        if(isUserContainsInDB(user.getLogin(), user.getPassword())){
            throw new ValidationException("Такого пользователя нет в системе");
        } else {
            HttpSession session = req.getSession();
        }
    }

    private boolean isUserContainsInDB(String login, String password){
        return sessionRepo.getUserByName(login, password) != null;
    }
}
