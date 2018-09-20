package ru.lanit.rest.service;

import ru.lanit.rest.dao.CarDAO;
import ru.lanit.rest.dao.PersonDAO;
import ru.lanit.rest.model.Car;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("/car")
public class CarService {

    @Inject
    private CarDAO carDAO;

    @Inject
    private PersonDAO personDAO;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Car addCar(Car car){
        car.setOwner(personDAO.getPerson(car.getOwnerId()));

        return carDAO.addCar(car);
    }

}