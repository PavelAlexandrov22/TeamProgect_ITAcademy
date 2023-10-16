package by.it.academy.jd2.messanger.services;

import by.it.academy.jd2.messanger.core.exeptions.ValidationException;
import by.it.academy.jd2.messanger.domain.Message;
import by.it.academy.jd2.messanger.domain.User;
import by.it.academy.jd2.messanger.repository.api.IMessageRepo;
import by.it.academy.jd2.messanger.repository.api.ISessionRepo;
import by.it.academy.jd2.messanger.services.api.IMessageService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageService implements IMessageService {

    private final IMessageRepo messageRepo;

    private final ISessionRepo sessionRepo;

    private User user;

    public MessageService(IMessageRepo messageService, ISessionRepo sessionRepo) {
        this.messageRepo = messageService;
        this.sessionRepo = sessionRepo;

    }


    @Override
    public void setMessage(Message message) throws ValidationException {

        if (isUserInSystem(message.getToId())) {
            messageRepo.addMessage(message);
        }

        if (isUserInSystem(message.getToLogin())) {
            message.setToId(user.getId().intValue());
            messageRepo.addMessage(message);
        }
    }


    /**
     * @param user user entity
     * @return list of messages, can return empty list if there are no messages
     */
    @Override
    public List<Message> getMessage(User user) {
        return messageRepo.getMessages(user.getId());
    }

    public List<Message> getMessage(String login) {
        return messageRepo.getMessages(sessionRepo.getUserByLogin(login).getId());
    }

    @Override
    public Map<String, Message> getChat(String login) throws ValidationException {
        if (!isUserInSystem(login)) {
            return null;
        } else {
            Map<String, Message> chats = new HashMap<>();
            getMessage(login).forEach(m -> chats.put(sessionRepo.getUser((long) m.getFromId()).getLogin(), m));
            return chats;
        }
    }

    private boolean isUserInSystem(long id) throws ValidationException {
        if (id <= 0) {
            throw new ValidationException("неверно указан id пользователя");
        } else {
            return sessionRepo.getUser(id) != null;
        }
    }

    /**
     * @param login
     * @return true if user registate in system
     * @throws ValidationException this method need object user, because we make sort in dao by user id
     *                             and if in object message we don`t fill field toId we won`t use this massage later
     */
    private  boolean isUserInSystem(String login) throws ValidationException {
        user = sessionRepo.getUserByLogin(login);
        if (user != null) {
            return true;
        } else {
            throw new ValidationException("неверно указан login пользователя");
        }
    }
}