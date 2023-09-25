package by.it.academy.jd2.messanger.repository.factory;

import by.it.academy.jd2.messanger.repository.UserRepo;
import by.it.academy.jd2.messanger.repository.api.IUserRepo;

public class UserRepoFactory {

    private volatile static IUserRepo instance;

    private UserRepoFactory() {
    }

    public static IUserRepo getInstance() {

        if (instance == null) {
            synchronized (UserRepoFactory.class) {
                if (instance == null) {
                    instance = new UserRepo();
                }
            }
        }
        return instance;
    }
}
