package by.it.academy.jd2.messanger.repository.factory;

import by.it.academy.jd2.messanger.repository.MessageRepo;
import by.it.academy.jd2.messanger.repository.SessionRepo;
import by.it.academy.jd2.messanger.repository.api.IMessageRepo;
import by.it.academy.jd2.messanger.repository.api.ISessionRepo;

public class MessageRepoFactory {
    private volatile static IMessageRepo instance;

    private MessageRepoFactory() {
    }

    public static IMessageRepo getInstance() {

        if (instance == null) {
            synchronized (MessageRepoFactory.class) {
                if (instance == null) {
                    instance = new MessageRepo();
                }
            }
        }
        return instance;
    }
}
