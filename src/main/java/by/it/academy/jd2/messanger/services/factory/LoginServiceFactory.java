package by.it.academy.jd2.messanger.services.factory;

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
                    //todoinstance = new LoginService(dao.getInstance());
                }
            }
        }
        return instance;
    }
}
