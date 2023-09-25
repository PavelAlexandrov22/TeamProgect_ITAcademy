package by.it.academy.jd2.messanger.repository.api;

import by.it.academy.jd2.messanger.domain.Message;

import java.util.List;

public interface IMessageRepo {

    List<Message> getMessages(Long idUser);

    void addMessage(Long toId,Message message);

    Long count();


}
