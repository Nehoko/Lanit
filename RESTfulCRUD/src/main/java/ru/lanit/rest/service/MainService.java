package ru.lanit.rest.service;

import ru.lanit.rest.dao.CarDAO;
import ru.lanit.rest.dao.PersonDAO;
import ru.lanit.rest.dao.StatisticsDAO;
import ru.lanit.rest.model.Statistics;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


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
        return statisticsDAO.getStatistics();
    }

    @Path("clear")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public String clearAll(){
        try {
            statisticsDAO.getStatistics().setUniquevendorcount(0L);
            statisticsDAO.getStatistics().setPersoncount(0L);
            statisticsDAO.getStatistics().setCarcount(0L);
            carDAO.deleteAllCars();
            personDAO.deleteAllPersons();
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
