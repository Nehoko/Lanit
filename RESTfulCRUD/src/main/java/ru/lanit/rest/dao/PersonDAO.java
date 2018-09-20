package ru.lanit.rest.dao;

import ru.lanit.rest.dto.CarDTO;
import ru.lanit.rest.dto.PersonDTO;
import ru.lanit.rest.model.Car;
import ru.lanit.rest.model.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ApplicationScoped
public class PersonDAO {

    @Inject
    private EntityManager entityManager;

    @Inject
    private StatisticsDAO statisticsDAO;


    public Person getPerson(Long id){
        return entityManager.find(Person.class, id);
    }



    public Person addPerson(Person person){
        statisticsDAO.getStatistics().incrementPersoncount();
        entityManager.merge(person);
        entityManager.flush();
        return entityManager.find(Person.class, person.getId());
    }

    public Person updatePerson(Person person){
        entityManager.merge(person);
        entityManager.flush();
        return entityManager.find(Person.class, person.getId());
    }

    public void deletePerson(Long id) throws Exception {
        statisticsDAO.getStatistics().decrementPersoncount();
        entityManager.remove(entityManager.find(Person.class, id));
        entityManager.flush();
    }

    public List<Person> getAllPersons(){
        EntityManagerFactory entityManagerFactory = entityManager.getEntityManagerFactory();
        CriteriaBuilder cb = entityManagerFactory.getCriteriaBuilder();
        CriteriaQuery<Person> personCriteriaQuery = cb.createQuery(Person.class);
        Root<Person> personRoot = personCriteriaQuery.from(Person.class);
        personCriteriaQuery.select(personRoot);

        return entityManager.createQuery(personCriteriaQuery).getResultList();
    }

    public void deleteAllPersons() throws Exception{
        ArrayList<Person> persons = (ArrayList<Person>) getAllPersons();
        for(Person person : persons){
            entityManager.remove(person);
        }
    }

}