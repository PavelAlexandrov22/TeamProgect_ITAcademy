package by.it.academy.jd2.messanger.services.api;
import by.it.academy.jd2.messanger.core.exeptions.ValidationException;
import by.it.academy.jd2.messanger.domain.Message;
import by.it.academy.jd2.messanger.domain.User;
import java.util.List;
import java.util.Map;

public interface IMessageService {
    void setMessage(Message message) throws ValidationException;

    List<Message> getMessage(User user);

    List<Message> getMessage(String login);

    Map<String,Message> getChat(String login) throws ValidationException;




}