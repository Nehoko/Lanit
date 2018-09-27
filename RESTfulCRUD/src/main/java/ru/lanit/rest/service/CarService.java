package ru.lanit.rest.service;

import ru.lanit.rest.dao.CarDAO;
import ru.lanit.rest.dao.PersonDAO;
import ru.lanit.rest.model.Car;
import ru.lanit.rest.model.Person;
import ru.lanit.rest.pojo.Validator;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.ParseException;

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
        Response ok = Response.status(Response.Status.OK).build();
        Response badRequest = Response.status(Response.Status.BAD_REQUEST).build();

        Person owner = personDAO.getPerson(car.getOwnerId());
        try {
            if(carDAO.getCar(car.getId())==null && owner!=null && owner.getAge()>18) {
                car.setOwner(owner);
            }
            else {
                return badRequest;
            }
        } catch (ParseException e) {
            return badRequest;
        }
        carDAO.addCar(car);
        Car car1 = carDAO.getCar(car.getId());
        String model = car1.getModel();
        if (car1.getId() != null && model != null && car1.getHorsepower() != null && car1.getOwnerId() != null && model.matches("^[a-zA-Z0-9]+-[a-zA-Z0-9]+$"))
        return ok;
        else {
            return badRequest;
        }
    }


}