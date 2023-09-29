package by.it.academy.jd2.messanger.repository;
import by.it.academy.jd2.messanger.domain.Message;
import by.it.academy.jd2.messanger.repository.api.IMessageRepo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MessageRepo implements IMessageRepo {

    private List<Message> messages=Collections.synchronizedList(new ArrayList<>());

    /**
     * @param idUser
     * @return list
     * method returning messages list of user
     * if list is no present, method returning you empty list
     */
    @Override
    public List<Message> getMessages(Long idUser) {
        List<Message> messageListOfCurrentUser= Collections.synchronizedList(new ArrayList<>());
        messages.stream().filter(p -> p.getToId()==idUser).forEach(messageListOfCurrentUser::add);
        return messageListOfCurrentUser;
    }

    /**
     * @param message
     * add message to recipient list by id
     */
    @Override
    public void addMessage(Message message) {
        messages.add(message);
    }

    /**
     * @param idUser
     * @return
     * give you count of messages
     */
    @Override
    public Long count(Long idUser) {
        return (long) getMessages(idUser).size();
    }


    public Long countAllMessages(){
        return (long) messages.size();
    }

}