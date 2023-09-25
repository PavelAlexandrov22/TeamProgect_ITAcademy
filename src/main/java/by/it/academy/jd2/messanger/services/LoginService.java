package by.it.academy.jd2.messanger.services;

import by.it.academy.jd2.messanger.core.exeptions.ValidationException;
import by.it.academy.jd2.messanger.domain.User;
import by.it.academy.jd2.messanger.repository.api.ISessionRepo;
import by.it.academy.jd2.messanger.services.api.ILoginService;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

public class LoginService implements ILoginService {

    private ISessionRepo sessionRepo;

    private HttpSession session;

    private User user;

    public LoginService(ISessionRepo userRepo) {
        this.sessionRepo = userRepo;
    }

    @Override
    public User login(User user) throws ValidationException {
        Optional<User> activeUser = sessionRepo.getUsersSet().stream().filter(f -> f.equals(user)).findFirst();
        if (activeUser.isPresent()) this.user = activeUser.get();
        else throw new ValidationException("Неверный логин или пароль");
        return this.user;
    }
}
