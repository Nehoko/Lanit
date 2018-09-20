package ru.lanit.rest.dao;

import ru.lanit.rest.model.Car;
import sun.awt.image.ImageWatched;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class CarDAO {

    @Inject
    private EntityManager entityManager;


    @Inject
    private StatisticsDAO statisticsDAO;

    @Resource
    UserTransaction userTransaction;


    public Car getCar(Long id){
        return entityManager.find(Car.class, id);
    }

    public Car addCar(Car car) {
        statisticsDAO.getStatistics().incrementCarcount();
        entityManager.merge(car);
        entityManager.flush();
        checkVendorUniqueness();
        return entityManager.find(Car.class, car.getId());
    }

    public  Car updateCar(Car car){
        entityManager.merge(car);
        entityManager.flush();
        checkVendorUniqueness();
        return entityManager.find(Car.class, car.getId());
    }

    public void deleteCar(Long id) throws Exception {
        statisticsDAO.getStatistics().decrementCarcount();
        entityManager.remove(entityManager.find(Car.class, id));
        entityManager.flush();
        checkVendorUniqueness();
    }

    public List<Car> getAllCars(){
        EntityManagerFactory entityManagerFactory = entityManager.getEntityManagerFactory();
        CriteriaBuilder cb = entityManagerFactory.getCriteriaBuilder();
        CriteriaQuery<Car> carCriteriaQuery = cb.createQuery(Car.class);
        Root<Car> carRoot = carCriteriaQuery.from(Car.class);
        carCriteriaQuery.select(carRoot);
        return entityManager.createQuery(carCriteriaQuery).getResultList();
    }

    public void deleteAllCars() throws Exception {
        ArrayList<Car> cars = (ArrayList<Car>)getAllCars();
       for(Car car : cars){
           userTransaction.begin();
           entityManager.remove(entityManager.find(Car.class,car.getId()));
           userTransaction.commit();
       }
    }

    private void checkVendorUniqueness(){
        long uvc = 0;
        ArrayList<Car> cars = (ArrayList<Car>) getAllCars();
        LinkedList<String> vendors = new LinkedList<>();

        while (!cars.isEmpty()){
            String[] vendor = cars.get(cars.size()-1).getModel().split("-");
            vendors.add(vendor[0]);
            cars.remove(cars.size()-1);
        }

        for(int i = 0 ; i<vendors.size(); i++){
            String vendor = vendors.get(i);
            boolean match = false;
            for (int j = i+1; i<vendors.size(); i++){
                String vendorTwo = vendors.get(j);
                if(vendor.equals(vendorTwo))
                    match = true;
            }
            if(!match)
                uvc++;
        }
        statisticsDAO.getStatistics().setUniquevendorcount(uvc);
    }
}
