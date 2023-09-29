package by.it.academy.jd2.messanger.services;

import by.it.academy.jd2.messanger.repository.api.IMessageRepo;
import by.it.academy.jd2.messanger.repository.api.ISessionRepo;
import by.it.academy.jd2.messanger.services.api.IStatisticService;
import jakarta.servlet.http.HttpSession;

public class StatisticService implements IStatisticService {
    private ISessionRepo sessionRepo;
    private IMessageRepo messageRepo;

    public StatisticService(ISessionRepo sessionRepo, IMessageRepo messageRepo) {
        this.sessionRepo = sessionRepo;
        this.messageRepo = messageRepo;
    }

    @Override
    public long getStatistics() {
        return sessionRepo.getCountActiveSession();
    }

    @Override
    public void updateStatistic(HttpSession session) {
        sessionRepo.getActiveSession().add(session);
    }

    public long getMessageStatistic() {
        return messageRepo.countAllMessages();
    }

}

