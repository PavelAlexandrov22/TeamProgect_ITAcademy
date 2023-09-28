package by.it.academy.jd2.messanger.services.factory;


import by.it.academy.jd2.messanger.repository.UserRepo;
import by.it.academy.jd2.messanger.repository.factory.SessionRepoFactory;
import by.it.academy.jd2.messanger.services.LoginService;
import by.it.academy.jd2.messanger.services.UserService;

import by.it.academy.jd2.messanger.services.api.IUserService;

public class UserServiceFactory {
    private volatile static UserService instance;

    private UserServiceFactory() {
    }

    public static IUserService getInstance() {
        if(instance == null){
            synchronized (UserServiceFactory.class){
                if(instance == null){
                    instance = new UserService(SessionRepoFactory.getInstance());
                }
            }
        }
        return instance;
    }
}