package ru.lanit.springboot.afisha.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import ru.lanit.springboot.afisha.entities.Afisha;
import ru.lanit.springboot.afisha.entities.Theater;
import ru.lanit.springboot.afisha.repos.AfishaRepository;
import ru.lanit.springboot.afisha.repos.TheaterRepository;

@Service
@Transactional(
        propagation = Propagation.SUPPORTS,
        readOnly = true)
public class AfishaService {

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    AfishaRepository afishaRepository;


    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Iterable<Afisha> getAfishaByTheaterAndName(Theater theater, String name){

        boolean isTransaction = TransactionSynchronizationManager.isActualTransactionActive();

        Theater currentTheater = theaterRepository.findByName(theater.getName()).get(0);

        return afishaRepository.findByTheaterAndName(currentTheater, name);
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Iterable<Afisha> getAfishaByTheater(Theater theater){

        boolean isTransaction = TransactionSynchronizationManager.isActualTransactionActive();

        Iterable<Afisha> afisha = theaterRepository.getByName(theater.getName()).get(0).getPerformances();

        return afisha;
    }
}
