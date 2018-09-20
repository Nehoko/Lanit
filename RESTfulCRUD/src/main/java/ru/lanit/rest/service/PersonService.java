package ru.lanit.rest.service;

import ru.lanit.rest.dao.PersonDAO;
import ru.lanit.rest.model.Person;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@RequestScoped
@Path("/")
public class PersonService {

    @Inject
    PersonDAO personDAO;

    @Path("personwithcars")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Person getPersonWithCars(@QueryParam("personid") Long personId){
        return personDAO.getPerson(personId);
    }


    @Path("person")
    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Person addPerson(Person person){
        return personDAO.addPerson(person);
    }
}
