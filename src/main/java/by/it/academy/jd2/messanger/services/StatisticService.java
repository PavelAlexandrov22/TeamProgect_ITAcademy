package by.it.academy.jd2.messanger.services;

import by.it.academy.jd2.messanger.repository.api.ISessionRepo;
import by.it.academy.jd2.messanger.services.api.IStatisticService;
import jakarta.servlet.http.HttpSession;

public class StatisticService implements IStatisticService {
    private ISessionRepo sessionRepo;

    public StatisticService(ISessionRepo sessionRepo) {
        this.sessionRepo = sessionRepo;
    }

    @Override
    public long getStatistics() {
        return sessionRepo.getCountActiveSession();
    }

    @Override
    public void updateStatistic(HttpSession session) {
      //todo  мне нужно положишь статистику в бд? Сергей? типо принять сессию и положить в сет статистик
    }
}
