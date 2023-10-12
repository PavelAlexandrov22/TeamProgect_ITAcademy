package by.it.academy.jd2.messanger.domain;

import java.time.LocalDate;
import java.util.Date;

public class User {
    private Long id;
    private String login;
    private String password;
    private String fio;

    private Date brDate;

    private Date siginDate;
    private String role;

    public User() {
    }



    public User(String login, String password, String fio, Date brDate,Date siginDate, String role) {
        this.login = login;
        this.password = password;
        this.fio = fio;
        this.brDate = brDate;
        this.siginDate=siginDate;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Date getBrDate() {
        return brDate;
    }

    public void setBrDate(Date brDate) {
        this.brDate = brDate;
    }

    public Date getSiginDate() {
        return siginDate;
    }

    public void setSiginDate(Date siginDate) {
        this.siginDate = siginDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!login.equals(user.login)) return false;
        if (!password.equals(user.password)) return false;
        return role.equals(user.role);
    }

    @Override
    public int hashCode() {
        int result = login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", fio='" + fio + '\'' +
                ", brDate=" + brDate +
                ", siginDate=" + siginDate +
                ", role='" + role + '\'' +
                '}';
    }

}

