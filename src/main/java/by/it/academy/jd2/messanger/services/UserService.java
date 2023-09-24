package by.it.academy.jd2.messanger.services;

import by.it.academy.jd2.messanger.domain.User;
import by.it.academy.jd2.messanger.core.exeptions.ValidationException;
import by.it.academy.jd2.messanger.repository.api.IUserRepo;
import by.it.academy.jd2.messanger.services.api.IUserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserService implements IUserService {

    private IUserRepo userRepo;

    private List<Character> illegalSymbols = new ArrayList<>
            (Arrays.asList('<', '>', '!', '@', '`', '.', ',', ';', ':', '\'', '\"'));
    @Override
    public void save(User user) throws ValidationException {
        if(isIllegalData(user)){
            userRepo.saveUser(user);
        } else {
            throw new ValidationException("Некорректный ввод");
        }
    }

    public boolean isIllegalData(User user) throws ValidationException{
        if (user.getLogin() == null || user.getPassword() == null){
            return false;
        }
        for (char c : illegalSymbols){
            if (user.getLogin().equals(c)){
                return false;
            }
            if (user.getPassword().equals(c)){
                return false;
            }
            if (user.getFio().equals(c)){
                return false;
            }
            if (user.getRole().equals(c)){
                return false;
            }
        }
        return true;
    }
}
