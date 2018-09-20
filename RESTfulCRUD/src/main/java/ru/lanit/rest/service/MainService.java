package ru.lanit.rest.service;

import ru.lanit.rest.dao.CarDAO;
import ru.lanit.rest.dao.PersonDAO;
import ru.lanit.rest.dao.StatisticsDAO;
import ru.lanit.rest.model.Car;
import ru.lanit.rest.model.Person;
import ru.lanit.rest.model.Statistics;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.LinkedList;


@RequestScoped
@Path("/")
public class MainService {

    @Inject
    StatisticsDAO statisticsDAO;

    @Inject
    PersonDAO personDAO;

    @Inject
    CarDAO carDAO;


    @Path("statistics")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Statistics getStatistics(){
        Statistics statistics = statisticsDAO.getStatistics();
        return statistics;
    }

    @Path("clear")
    @GET
    @Transactional
    public Statistics clearAll(){
        try {
            carDAO.deleteAllCars();
            personDAO.getAllPersons();
            return statisticsDAO.getStatistics();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
