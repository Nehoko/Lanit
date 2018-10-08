package ru.lanit.springboot.afisha.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.lanit.springboot.afisha.entities.Theater;

import java.util.List;

public interface TheaterRepository extends CrudRepository<Theater, Integer> {
    List<Theater> findByName(String name);
    List<Theater> getByName(String name);
}
