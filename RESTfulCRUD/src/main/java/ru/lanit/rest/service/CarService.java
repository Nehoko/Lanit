package ru.lanit.rest.service;

import ru.lanit.rest.dao.CarDAO;
import ru.lanit.rest.dao.PersonDAO;
import ru.lanit.rest.model.Car;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/car")
public class CarService {

    @Inject
    private CarDAO carDAO;

    @Inject
    PersonDAO personDAO;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response addCar(Car car){
        car.setOwner(personDAO.getPerson(car.getOwnerId()));
        carDAO.addCar(car);
        Car car1 = carDAO.getCar(car.getId());
        String model = car1.getModel();
        if (car1!=null && car1.getId()!=null && model!=null && car1.getHorsepower()!=null && car1.getOwnerId()!=null && model.matches("^[a-zA-Z0-9]+-[a-zA-Z0-9]+$"))
        return Response.status(Response.Status.OK).build();
        else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }


}