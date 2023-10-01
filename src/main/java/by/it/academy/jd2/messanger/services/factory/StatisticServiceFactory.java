package by.it.academy.jd2.messanger.services.factory;

import by.it.academy.jd2.messanger.repository.factory.MessageRepoFactory;
import by.it.academy.jd2.messanger.repository.factory.SessionRepoFactory;
import by.it.academy.jd2.messanger.services.StatisticService;
import by.it.academy.jd2.messanger.services.api.IStatisticService;

public class StatisticServiceFactory {
    private volatile static StatisticService instance;

    private StatisticServiceFactory() {
    }

    public static IStatisticService getInstance() {
        if(instance == null){
            synchronized (StatisticServiceFactory.class){
                if(instance == null){
                    instance = new StatisticService(SessionRepoFactory.getInstance(), MessageRepoFactory.getInstance());
                }
            }
        }
        return  instance;
    }

}