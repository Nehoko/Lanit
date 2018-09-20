package ru.lanit.rest.dao;

import ru.lanit.rest.model.Statistics;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class StatisticsDAO {

    @Inject
    private EntityManager entityManager;

    public  Statistics getStatistics(){
        return entityManager.find(Statistics.class,1L);
    }

}
