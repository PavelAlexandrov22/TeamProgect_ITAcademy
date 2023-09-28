package by.it.academy.jd2.messanger.services.factory;
import by.it.academy.jd2.messanger.repository.factory.MessageRepoFactory;
import by.it.academy.jd2.messanger.repository.factory.SessionRepoFactory;
import by.it.academy.jd2.messanger.services.MessageService;
import by.it.academy.jd2.messanger.services.StatisticService;
import by.it.academy.jd2.messanger.services.api.IMessageService;
import by.it.academy.jd2.messanger.services.api.IStatisticService;


public class MessageServiceFactory {
    private volatile static MessageService instance;

    private MessageServiceFactory() {
    }

    public static IMessageService getInstance() {
        if (instance == null) {
            synchronized (MessageServiceFactory.class) {
                if (instance == null) {
                    instance = new MessageService(MessageRepoFactory.getInstance(), SessionRepoFactory.getInstance());
                }
            }
        }
        return instance;
    }

}

