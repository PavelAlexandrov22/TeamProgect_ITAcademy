package by.it.academy.jd2.messanger.services;

import by.it.academy.jd2.messanger.domain.User;
import by.it.academy.jd2.messanger.core.exeptions.ValidationException;
import by.it.academy.jd2.messanger.repository.api.ISessionRepo;
import by.it.academy.jd2.messanger.services.api.IUserService;
import jakarta.servlet.http.HttpSession;

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

    @Override
    public void logout(String login) {
        if (sessionRepo.getActiveSession().stream().anyMatch(s -> s.getAttribute("user").equals(login))) {
            HttpSession httpSession = sessionRepo.getActiveSession().stream().filter(s -> s.getAttribute("user").equals(login)).findFirst().get();
            sessionRepo.getActiveSession().remove(httpSession);
        }
    }


    private void passwordValidation(String password) throws ValidationException {
        if(password.length() <8 || password.length() > 32){
            throw new ValidationException("Длина пароля должна составлять от 8 до 32 символов");
        }
        if(!password.matches("[a-zA-Z0-9_-]{8,32}")){
            throw new ValidationException("Пароль может содержать латинские буквы, цифры 0-9, а также символы '_' и '-'");
        }
    }

    private void loginValidation(String login) throws ValidationException {
        if(login.length() <8 || login.length() > 16){
            throw new ValidationException("Длина логина должна составлять от 8 до 16 символов");
        }
        if(!login.matches("[a-zA-Z0-9_-]{4,16}")){
            throw new ValidationException("Логин может содержать латинские буквы, цифры 0-9, а также символы '_' и '-'");
        }
    }

    private void fioValidation(String fio) throws ValidationException {
        if(!fio.matches("[A-Za-zа-яА-я]+ [A-Za-zа-яА-я]+ [A-Za-zа-яА-я]+$")){
            throw new ValidationException("Неверный формат ФИО. ФИО должно состоять из букв и пробелов");
        }
    }

    private void brDayValidation(Date brDay) throws ValidationException {
        Date currentDate = new Date();

        if (brDay == null) {
            throw new ValidationException("Не указана дата дня рождения");
        }
        if (brDay.after(currentDate)) {
            throw new ValidationException("Дата дня рождения не может быть в будущем времени");
        }
    }


}