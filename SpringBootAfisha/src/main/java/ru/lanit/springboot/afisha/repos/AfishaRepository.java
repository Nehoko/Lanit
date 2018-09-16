package ru.lanit.springboot.afisha.repos;

import org.springframework.data.repository.CrudRepository;
import ru.lanit.springboot.afisha.entities.Afisha;
import ru.lanit.springboot.afisha.entities.Theater;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface AfishaRepository extends CrudRepository<Afisha, Integer> {
    List<Afisha> findByName(String name);
    List<Afisha> findByTheater(Theater theater);
    List<Afisha> findByTheaterAndName(Theater theater, String name);
}
