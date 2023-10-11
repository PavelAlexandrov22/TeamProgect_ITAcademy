package by.it.academy.jd2.messanger.repository.factory;

import by.it.academy.jd2.messanger.repository.SessionRepo;
import by.it.academy.jd2.messanger.repository.api.ISessionRepo;

public class SessionRepoFactory {
    private volatile static ISessionRepo instance;

    private SessionRepoFactory() {
    }

    public static ISessionRepo getInstance() {

        if (instance == null) {
            synchronized (SessionRepoFactory.class) {
                if (instance == null) {
                    instance = new SessionRepo(UserRepoFactory.getInstance());
                }
            }
        }
        return instance;
    }
}
