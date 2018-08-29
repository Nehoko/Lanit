package ru.lanit.springboot.afisha.repos;

import org.springframework.data.repository.CrudRepository;
import ru.lanit.springboot.afisha.entities.Theater;

import java.util.List;

public interface TheaterRepository extends CrudRepository<Theater, Integer> {
    List<Theater> findByName(String name);
}
