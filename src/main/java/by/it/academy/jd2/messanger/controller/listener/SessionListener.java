package by.it.academy.jd2.messanger.controller.listener;

import by.it.academy.jd2.messanger.services.api.IStatisticService;
import by.it.academy.jd2.messanger.services.factory.StatisticServiceFactory;
import jakarta.servlet.http.*;

public class SessionListener implements HttpSessionAttributeListener {


    private  final IStatisticService statisticService;

    public SessionListener() {
        this.statisticService = StatisticServiceFactory.getInstance();
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        if("user".equalsIgnoreCase(event.getName()) && event.getValue() != null){
            this.statisticService.getStatistics();
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        HttpSessionAttributeListener.super.attributeRemoved(event);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        HttpSessionAttributeListener.super.attributeReplaced(event);
    }
}
