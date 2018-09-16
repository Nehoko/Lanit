package ru.lanit.rest.dao;

import ru.lanit.rest.model.Car;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@ApplicationScoped
public class CarDAO {

    @Inject
    private EntityManager entityManager;


    public Car getCar(Long id){
        return entityManager.find(Car.class, id);
    }

    public Car addCar(Car car){
        return entityManager.merge(car);
    }

    public  Car updateCar(Car car){
        return entityManager.merge(car);
    }

    public void deleteCar(Long id){
        entityManager.remove(entityManager.find(Car.class, id));
    }

    public List<Car> getAllCars(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Car> carCriteriaQuery = cb.createQuery(Car.class);
        return entityManager.createQuery(carCriteriaQuery).getResultList();
    }
}
