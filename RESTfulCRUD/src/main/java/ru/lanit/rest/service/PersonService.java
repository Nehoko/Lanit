package ru.lanit.rest.service;

import ru.lanit.rest.dao.PersonDAO;
import ru.lanit.rest.dto.CarDTO;
import ru.lanit.rest.dto.PersonDTO;
import ru.lanit.rest.model.Car;
import ru.lanit.rest.model.Person;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashSet;
import java.util.Set;


@RequestScoped
@Path("/")
public class PersonService {

    @Inject
    PersonDAO personDAO;

    @Path("personwithcars")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getPersonWithCars(@QueryParam("personid") String personId){

        if (!personIdIsLong(personId))
            return Response.status(Response.Status.BAD_REQUEST).build();
        Long id = Long.parseLong(personId);

        Person person = personDAO.getPerson(id);
        if(person==null)
            return Response.status(Response.Status.NOT_FOUND).build();

        PersonDTO personDTO = setPersonDTO(person);

        return Response.status(Response.Status.OK).entity(personDTO).build();
    }


    @Path("person")
    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPerson(Person person){
        personDAO.addPerson(person);
        if (personDAO.getPerson(person.getId())!=null)
        return Response.status(Response.Status.OK).build();
        else{
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    private PersonDTO setPersonDTO(Person person){
        Set<Car> carSet = person.getCars();
        Set<CarDTO> cars = setCarDTO(carSet);
        PersonDTO personDTO = new PersonDTO();

        personDTO.setBirthdate(person.getBirthdate());
        personDTO.setId(person.getId());
        personDTO.setName(person.getName());
        personDTO.setCars(cars);
        return personDTO;
    }

    private Set<CarDTO> setCarDTO(Set<Car> carSet){
        Set<CarDTO> cars = new HashSet<>();
        for(Car car : carSet){
            CarDTO carDTO = new CarDTO();
            carDTO.setId(car.getId());
            carDTO.setModel(car.getModel());
            carDTO.setHorsepower(car.getHorsepower());
            carDTO.setOwnerId(car.getOwnerId());
            cars.add(carDTO);
        }
        return cars;
    }

    private boolean personIdIsLong(String personId){

        try{
            Long id = Long.parseLong(personId);
        }
        catch (NumberFormatException | NullPointerException e){
            return false;
        }
        return true;
    }
}
