package by.it.academy.jd2.messanger.services;

import by.it.academy.jd2.messanger.core.exeptions.ValidationException;
import by.it.academy.jd2.messanger.domain.Message;
import by.it.academy.jd2.messanger.repository.api.IMessageRepo;
import by.it.academy.jd2.messanger.repository.api.ISessionRepo;
import by.it.academy.jd2.messanger.services.api.IMessageService;

public class MessageService implements IMessageService {

    private IMessageRepo messageRepo;

    private ISessionRepo sessionRepo;


    public MessageService(IMessageRepo messageService, ISessionRepo sessionRepo){
        this.messageRepo = messageService;
        this.sessionRepo = sessionRepo;

    }

    @Override
    public void setMessage(Message message) throws ValidationException {
        if (isId(message.getToId())){
            messageRepo.addMessage(message);
        } else {
            throw new ValidationException("такго пользователя нет в системе");
        }
    }

    private boolean isId(long id){
        return sessionRepo.getUser(id) != null;
    }
}
