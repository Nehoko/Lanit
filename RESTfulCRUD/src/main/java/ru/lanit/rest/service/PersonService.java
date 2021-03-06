package ru.lanit.rest.service;

import ru.lanit.rest.dao.PersonDAO;
import ru.lanit.rest.dto.CarDTO;
import ru.lanit.rest.dto.PersonDTO;
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
        Response badRequest = Response.status(Response.Status.BAD_REQUEST).build();
        Response notFound = Response.status(Response.Status.NOT_FOUND).build();

        if (!Validator.isLong(personId) || personId==null)
            return badRequest;
        Long id = Long.parseLong(personId);

        Person person = personDAO.getPerson(id);
        if(person==null)
            return notFound;

        PersonDTO personDTO = setPersonDTO(person);
        Response ok = Response.status(Response.Status.OK).entity(personDTO).build();

        return ok;
    }


    @Path("person")
    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPerson(Person person){

        Response badRequest = Response.status(Response.Status.BAD_REQUEST).build();
        Response ok = Response.status(Response.Status.OK).build();

        try {
        if(!Validator.isLong(person.getId().toString()) || personDAO.getPerson(person.getId())!=null) {
            return badRequest;
        }

            if (person.getId() != null && person.getBirthdate() != null && person.getName() != null) {
                personDAO.addPerson(person);
                return ok;
            } else {
                return badRequest;
            }
        }catch (NullPointerException e){
            return badRequest;
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



//    private boolean isDateValid(final String date) {
//        Date currentDate = new Date();
//        String formatString = "dd.MM.yyyy";
//        boolean isInvalidFormat;
//        Date dateObj;
//        try {
//            SimpleDateFormat sdf = (SimpleDateFormat) DateFormat.getDateInstance();
//            sdf.applyPattern(formatString);
//            sdf.setLenient(false);
//            dateObj = sdf.parse(date);
//            if (date.equals(sdf.format(dateObj)) && dateObj.compareTo(currentDate)>0) {
//                isInvalidFormat = false;
//            }
//            else {
//                isInvalidFormat = true;
//            }
//        } catch (ParseException e) {
//            isInvalidFormat = true;
//        }
//        return isInvalidFormat;
//    }
}
