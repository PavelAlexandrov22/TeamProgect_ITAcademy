package by.it.academy.jd2.messanger.services;

import by.it.academy.jd2.messanger.core.exeptions.ValidationException;
import by.it.academy.jd2.messanger.domain.Message;
import by.it.academy.jd2.messanger.domain.User;
import by.it.academy.jd2.messanger.repository.api.IMessageRepo;
import by.it.academy.jd2.messanger.repository.api.ISessionRepo;
import by.it.academy.jd2.messanger.services.api.IMessageService;

import java.util.List;

public class MessageService implements IMessageService {

    private IMessageRepo messageRepo;

    private ISessionRepo sessionRepo;

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

        if (isUserInSystem(message.getToLogin())){
            message.setToId(user.getId().intValue());
            messageRepo.addMessage(message);
        }
    }


    /**
     * @param user
     * @return list of messages, can return empty list if there are no messages
     */
    @Override
    public List<Message> getMessage(User user) {
        return messageRepo.getMessages(user.getId());
    }

    private boolean isUserInSystem(long id) throws ValidationException {
        if (id <= 0) {
            throw new ValidationException("неверно указан id пользователя");
        } else {
            return sessionRepo.getUser(id) != null;
        }
    }

    /**
     *
     * @param login
     * @return true if user registate in system
     * @throws ValidationException
     * this method need object user, because we make sort in dao by user id
     * and if in object message we don`t fill field toId we won`t use this massage later
     */
    private boolean isUserInSystem(String login) throws ValidationException{
        user = sessionRepo.getUserByLogin(login);
        if (user != null){
            return true;
        } else {
            throw new ValidationException("неверно указан login пользователя");
        }
    }
}
