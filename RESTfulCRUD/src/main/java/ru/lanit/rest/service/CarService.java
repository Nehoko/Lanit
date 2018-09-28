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

        try {
            Long ownerId = car.getOwnerId();
            String model = car.getModel();

            if(car.getId() != null && model != null && car.getHorsepower() != null && car.getOwnerId() != null
                    && model.matches("^[a-zA-Z0-9]+-[a-zA-Z0-9]+$") && carDAO.getCar(car.getId())==null
                    && personDAO.getPerson(ownerId)!=null && personDAO.getPerson(ownerId).getAge()>18) {
                Person owner = personDAO.getPerson(ownerId);
                car.setOwner(owner);
            }
            else {
                return badRequest;
            }
        } catch (ParseException | NullPointerException e) {
            return badRequest;
        }
        carDAO.addCar(car);
        Car car1 = carDAO.getCar(car.getId());

        if(car1!=null) {
            return ok;
        }
        else{
            return badRequest;
        }
    }
}