package by.it.academy.jd2.messanger.repository.postgres.factory;

import by.it.academy.jd2.messanger.repository.SessionRepo;
import by.it.academy.jd2.messanger.repository.api.ISessionRepo;
import by.it.academy.jd2.messanger.repository.factory.SessionRepoFactory;
import by.it.academy.jd2.messanger.repository.factory.UserRepoFactory;
import by.it.academy.jd2.messanger.repository.postgres.DBSessionRepo;

public class DBSessionRepoFactory {
    private volatile static ISessionRepo instance;

    private DBSessionRepoFactory() {
    }

    public static ISessionRepo getInstance() {

        if (instance == null) {
            synchronized (DBSessionRepoFactory.class) {
                if (instance == null) {
                    instance = new DBSessionRepo();
                }
            }
        }
        return instance;
    }
}
