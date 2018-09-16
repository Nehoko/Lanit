package ru.lanit.rest.dao;

import ru.lanit.rest.model.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@ApplicationScoped
public class PersonDAO {

    @Inject
    private EntityManager entityManager;

    public Person getPerson(Long id){

        return entityManager.find(Person.class, id);

    }

    public Person addPerson(Person person){
        return entityManager.merge(person);
    }

    public Person updatePerson(Person person){
        return entityManager.merge(person);
    }

    public void deletePerson(Long id){
        entityManager.remove(entityManager.find(Person.class, id));
    }

    public List<Person> getAllPersons(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> personCriteriaQuery = cb.createQuery(Person.class);

        return entityManager.createQuery(personCriteriaQuery).getResultList();
    }

}