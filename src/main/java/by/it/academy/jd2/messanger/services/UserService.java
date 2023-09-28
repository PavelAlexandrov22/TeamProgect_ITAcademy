package by.it.academy.jd2.messanger.services;
import by.it.academy.jd2.messanger.domain.User;
import by.it.academy.jd2.messanger.core.exeptions.ValidationException;
import by.it.academy.jd2.messanger.repository.api.ISessionRepo;
import by.it.academy.jd2.messanger.services.api.IUserService;
import java.util.Date;


public class UserService implements IUserService {

    private ISessionRepo sessionRepo;

    public UserService(ISessionRepo sessionRepo) {
        this.sessionRepo = sessionRepo;
    }

    @Override
    public void save(User user) throws ValidationException {
        loginValidation(user.getLogin());
        passwordValidation(user.getPassword());
        fioValidation(user.getFio());
        brDayValidation(user.getBrDate());
        sessionRepo.saveUser(user);
    }


    private void passwordValidation(String login) throws ValidationException {
        if (!login.matches("^[A-Za-z_-]{4,32}$")) {
            throw new ValidationException("Неверный формат для логина");
        }
    }

    private void loginValidation(String password) throws ValidationException {
        if (!password.matches("^[a-zA-Z_-]{4,16}$")) {
            throw new ValidationException("Неверный формат для пароля");
        }
    }

    private void fioValidation(String fio) throws ValidationException {
        if (!fio.matches("^[A-Za-z]+ [A-Za-z]+ [A-Za-z]+$")) {
            throw new ValidationException("Неверное ФИО");
        }
    }

    private void brDayValidation(Date brDay) throws ValidationException {
        Date currentDate = new Date();

        if (brDay == null) {
            throw new ValidationException("Дата дня рождения не может быть null.");
        }
        if (brDay.after(currentDate)) {
            throw new ValidationException("Дата дня рождения не может быть в будущем.");
        }
    }
}