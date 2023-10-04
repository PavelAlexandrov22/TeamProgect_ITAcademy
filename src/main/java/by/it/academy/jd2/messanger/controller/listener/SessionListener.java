package by.it.academy.jd2.messanger.controller.listener;

import by.it.academy.jd2.messanger.services.api.IStatisticService;
import by.it.academy.jd2.messanger.services.factory.StatisticServiceFactory;
import jakarta.servlet.http.*;

public class SessionListener implements HttpSessionAttributeListener {


    private final IStatisticService statisticService;

    public SessionListener() {
        this.statisticService = StatisticServiceFactory.getInstance();
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        if ("user".equalsIgnoreCase(event.getName()) && event.getValue() != null) {
            this.statisticService.incSessionCount();
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        if ("user".equalsIgnoreCase(event.getName())) {
            this.statisticService.decSessionCount();
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        if ("user".equalsIgnoreCase(event.getName())) {
            if (event.getValue() != null) {
                this.statisticService.decSessionCount();
                this.statisticService.incSessionCount();
            } else {
                this.statisticService.decSessionCount();
            }

        }

    }
}
