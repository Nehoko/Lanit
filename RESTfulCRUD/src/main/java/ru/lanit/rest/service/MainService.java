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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.LinkedList;


@RequestScoped
public class MainService {

    @Inject
    StatisticsDAO statisticsDAO;

    @Inject
    PersonDAO personDAO;

    @Inject
    CarDAO carDAO;

    @Inject
    EntityManager entityManager;

    @Path("/statistics")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Statistics getStatistics(){
        return statisticsDAO.getStatistics();
    }

    @Path("/clear")
    @GET
    public void clearAll(){
        LinkedList<Person> personList = (LinkedList<Person>) personDAO.getAllPersons();
        while(!personList.isEmpty()) {
            entityManager.remove(personList.getFirst());
            personList.removeFirst();
        }
        LinkedList<Car> carList = (LinkedList<Car>) carDAO.getAllCars();
        while (!carList.isEmpty()){
            entityManager.remove(carList.getFirst());
            carList.removeFirst();
        }
    }

}
