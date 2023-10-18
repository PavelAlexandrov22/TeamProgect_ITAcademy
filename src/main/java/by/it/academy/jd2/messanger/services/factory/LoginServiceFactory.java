package by.it.academy.jd2.messanger.services.factory;

import by.it.academy.jd2.messanger.repository.SessionRepo;
import by.it.academy.jd2.messanger.repository.UserRepo;
import by.it.academy.jd2.messanger.repository.factory.SessionRepoFactory;
import by.it.academy.jd2.messanger.repository.postgres.factory.DBSessionRepoFactory;
import by.it.academy.jd2.messanger.services.LoginService;
import by.it.academy.jd2.messanger.services.api.ILoginService;

public class LoginServiceFactory {
    private volatile static LoginService instance;

    private LoginServiceFactory() {
    }

    public static ILoginService getInstance() {
        if(instance == null){
            synchronized (LoginServiceFactory.class){
                if(instance == null){
                    instance = new LoginService(DBSessionRepoFactory.getInstance());
                }
            }
        }
        return instance;
    }
}