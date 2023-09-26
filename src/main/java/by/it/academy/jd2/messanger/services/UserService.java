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

    private final List<Character> illegalSymbols = new ArrayList<>
            (Arrays.asList('<', '>', '!', '`', ',', ';', ':', '\'', '\"'));

    public UserService(IUserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void save(User user) throws ValidationException {
        if (isIllegalData(user)) {
             userRepo.saveUser(user);
        } else {
            throw new ValidationException("Некорректный ввод");
        }
    }

    public boolean isIllegalData(User user) {
        if (user.getLogin() == null || user.getPassword() == null) {
            return false;
        }
        boolean flag = true;
        for (char c : illegalSymbols) {
            if (user.getLogin().equals(c) || user.getPassword().equals(c) ||
                    user.getFio().equals(c) || user.getRole().equals(c)) {
                flag = false;
            }
        }
        return flag;
    }
}
