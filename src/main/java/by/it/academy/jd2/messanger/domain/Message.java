package by.it.academy.jd2.messanger.domain;

import java.util.Date;
import java.util.Objects;

public class Message {
    private int fromId;

    private int toId;

    //fixme please delete this
    private String toLogin;
    private String messageBody;

    private Date date;

    public Message() {
    }

    public Message(int fromId, int toId, String messageBody) {
        this.fromId = fromId;
        this.toId = toId;
        this.messageBody = messageBody;
    }

    public Message(int fromId, int toId, String messageBody, Date date) {
        this.fromId = fromId;
        this.toId = toId;
        this.messageBody = messageBody;
        this.date=date;
    }

    public int getFromId() {
        return fromId;
    }

    public void setFromId(int fromId) {
        this.fromId = fromId;
    }

    public int getToId() {
        return toId;
    }

    public void setToId(int toId) {
        this.toId = toId;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public String getToLogin() {
        return toLogin;
    }

    public void setToLogin(String toLogin) {
        this.toLogin = toLogin;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return fromId == message.fromId && toId == message.toId && Objects.equals(toLogin, message.toLogin) && Objects.equals(messageBody, message.messageBody);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromId, toId, toLogin, messageBody);
    }
}