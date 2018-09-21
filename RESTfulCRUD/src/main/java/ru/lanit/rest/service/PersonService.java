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
    public PersonDTO getPersonWithCars(@QueryParam("personid") Long personId){

        return setPersonDTO(personDAO.getPerson(personId));
    }


    @Path("person")
    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public String addPerson(Person person){
        personDAO.addPerson(person);
        return "";
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
}
