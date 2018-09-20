package ru.lanit.rest.dao;

import ru.lanit.rest.model.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
        return entityManager.find(Person.class, person);
    }

    public Person updatePerson(Person person){
        entityManager.merge(person);
        entityManager.flush();
        return entityManager.find(Person.class, person);
    }

    public void deletePerson(Long id) throws Exception {
        statisticsDAO.getStatistics().decrementPersoncount();
        entityManager.remove(entityManager.find(Person.class, id));
        entityManager.flush();
    }

    public List<Person> getAllPersons(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> personCriteriaQuery = cb.createQuery(Person.class);

        return entityManager.createQuery(personCriteriaQuery).getResultList();
    }

    public void deleteAllPersons() throws Exception{
        ArrayList<Person> persons = (ArrayList<Person>) getAllPersons();
        while (!persons.isEmpty()){
            deletePerson((long) (persons.size()-1));
        }
    }

}