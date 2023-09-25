package by.it.academy.jd2.messanger.repository;

import by.it.academy.jd2.messanger.domain.User;
import by.it.academy.jd2.messanger.domain.Message;
import by.it.academy.jd2.messanger.repository.api.IMessageRepo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class MessageRepo implements IMessageRepo {
    @Override
    public List<Message> getMessages(Long idUser, List<User> users) {
        Optional<User> userPresents=users.stream().filter(p -> p.getId().equals(idUser)).findFirst();
        return userPresents.map(User::getMessages).orElse(new ArrayList<>());
    }

    @Override
    public void addMessage(Long toId, List<User> users, Message message) {
        getMessages(toId,users).add(message);
    }

    @Override
    public Long count(Long idUser, List<User> users) {
        return (long) getMessages(idUser, users).size();
    }


}
