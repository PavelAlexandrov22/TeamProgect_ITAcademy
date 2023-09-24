package by.it.academy.jd2.messanger.repository;

import by.it.academy.jd2.messanger.domain.Message;
import by.it.academy.jd2.messanger.repository.api.IMessageRepo;

import java.util.List;

public class MessageRepo implements IMessageRepo {
    @Override
    public List<Message> getMessages(Long idUser) {
        return null;
    }

    @Override
    public void addMessage(Long toId, Message message) {

    }

    @Override
    public Long count() {
        return 0L;
    }
}
