package by.it.academy.jd2.messanger.repository.api;

import by.it.academy.jd2.messanger.domain.Message;
import by.it.academy.jd2.messanger.domain.User;

import java.util.List;

public interface IMessageRepo {

    List<Message> getMessages(Long idUser, List<User> users);

    void addMessage(Long toId,List<User> users,Message message);

    Long count(Long idUser,List<User> users);




}
